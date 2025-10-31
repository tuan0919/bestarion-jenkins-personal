// Tên job sẽ được tạo trong Jenkins
pipelineJob('hello-world-pipeline') {
    description('A simple pipeline created via Job DSL for testing purposes.')

    definition {
        cps {
            // Pipeline script viết trực tiếp trong DSL (không cần GitHub hay Jenkinsfile)
            script("""
                pipeline {
                    agent any

                    stages {
                        stage('Hello') {
                            steps {
                                echo 'Hello from Job DSL!'
                            }
                        }

                        stage('Build') {
                            steps {
                                echo 'Building project...'
                                sh 'sleep 2'
                            }
                        }

                        stage('Test') {
                            steps {
                                echo 'Running simple test...'
                                sh 'echo OK > result.txt'
                            }
                        }

                        stage('Deploy') {
                            steps {
                                echo 'Deploying...'
                            }
                        }
                    }

                    post {
                        success {
                            echo 'Pipeline finished successfully!'
                        }
                        failure {
                            echo 'Pipeline failed!'
                        }
                    }
                }
            """.stripIndent())
            sandbox(true) // Cho phép chạy trong sandbox mode để test an toàn
        }
    }

    properties {
        disableConcurrentBuilds() // Không cho chạy song song
    }
}
