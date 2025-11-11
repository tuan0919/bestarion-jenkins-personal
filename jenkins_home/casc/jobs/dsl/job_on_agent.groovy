pipelineJob('job-on-agent') {
    description('A pipeline job that runs on a specific agent.')
    definition {
        cps {
            script("""
                node('jenkins-agent') {
                    stage('Build') {
                        echo 'Building on the specified agent...'
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