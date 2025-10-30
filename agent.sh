#!/bin/bash
set -Eeuo pipefail
trap 'echo "❌ Error on line $LINENO: $BASH_COMMAND" >&2' ERR

JENKINS_URL="http://jenkins-server:8080"
echo "⏳ Waiting for Jenkins to be ready..."

# Chờ đến khi API sẵn sàng
until curl -sf "${JENKINS_URL}/login" >/dev/null; do
  echo "Jenkins not ready yet... retrying in 5s"
  sleep 5
done

echo "✅ Jenkins is up, registering agent..."

AGENT_METADATA="$(curl -s -u "admin:${ADMIN_PASSWORD}" ${JENKINS_URL}/computer/jenkins-agent/jenkins-agent.jnlp)"
AGENT_SECRET="$(echo "$AGENT_METADATA" | sed "s/.*<application-desc><argument>\([a-z0-9]*\).*/\1\n/")"

echo "🔑 Got agent secret: $AGENT_SECRET"
export JENKINS_SECRET="$AGENT_SECRET"
export JENKINS_AGENT_NAME="jenkins-agent"
export JENKINS_URL="$JENKINS_URL"

exec jenkins-agent