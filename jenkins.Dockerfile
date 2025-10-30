FROM jenkins/jenkins:2.528.1-lts

# Install Jenkins plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Disable the setup wizard as we will set up Jenkins as code
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

# Copy the Configuration as Code (CasC) YAML file into the image
USER root
RUN mkdir -p /var/jenkins_home
RUN apt-get update && apt-get install -y curl gawk jq
COPY jenkins_home/casc/ /var/jenkins_home/casc/
RUN chown -R jenkins:jenkins /var/jenkins_home/

USER jenkins

EXPOSE 8080 50000