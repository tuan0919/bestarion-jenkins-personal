pipelineJob('job-on-agent') {
    description('A pipeline job that runs on a specific agent.')
    definition {
        cps {
            script("""
                node('jenkins-agent') {
                    stage('Build') {
                        sh 'hostname -I'
                    }
                    stage('Test') {
                        sh 'ps -aux'
                    }
                }
            """.stripIndent())
            sandbox()
        }
    }
}