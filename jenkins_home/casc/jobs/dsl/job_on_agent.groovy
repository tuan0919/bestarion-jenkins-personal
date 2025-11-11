pipelineJob('job-on-agent') {
    description('A pipeline job that runs on a specific agent.')
    definition {
        cps {
            script("""
                node('jenkins-agent') {
                    stage('Build') {
                        ps -aux
                    }
                    stage('Test') {
                        echo 'Testing on the specified agent...'
                    }
                }
            """.stripIndent())
            sandbox()
        }
    }
}