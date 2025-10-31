pipelineJob('casc-pipeline') {
    description('JCasC managed pipeline for testing')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/tuan0919/bestarion-jenkins-personal.git')
                        credentials('github-key')
                    }
                    branch('test/jenkins-pipeline')
                }
            }
            scriptPath('jenkins_home/casc/Jenkinsfile')
        }
    }
    triggers {
        gitHubPush()
    }
    properties {
        disableConcurrentBuilds()
    }
}
