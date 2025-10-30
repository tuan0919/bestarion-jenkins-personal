pipelineJob('casc-pipeline') {
    description('JCasC managed pipeline for testing')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/minhhieu16/bestarion-jenkins.git')
                        credentials('github-key')
                    }
                    branch('test/jenkins-pipeline')
                }
            }
            scriptPath('jenkins_home/casc/Jenkinsfile')
        }
    }
    triggers {
        scm('H/1 * * * *')
    }
    properties {
        disableConcurrentBuilds()
    }
}
