FROM jenkins/inbound-agent:jdk21

USER root
RUN apt-get update && apt-get install -y curl gawk jq
COPY agent.sh /agent.sh
RUN chmod +x /agent.sh && chown jenkins:jenkins /agent.sh
USER jenkins
ENTRYPOINT ["/agent.sh"]