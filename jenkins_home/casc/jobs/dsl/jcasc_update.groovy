pipelineJob('casc-pipeline') {
    description('Pipeline dùng để validate và deploy cấu hình Jenkins Configuration as Code (JCasC)')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/tuan0919/bestarion-jenkins-personal.git')
                        credentials('github-key')
                    }
                    branch('main')
                }
            }
            scriptPath('jenkins_home/casc/Jenkinsfile')
        }
    }
    properties {
        disableConcurrentBuilds()
    }
}
