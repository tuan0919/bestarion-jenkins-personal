job('project-a/simple-job') {
    description('This is a simple Jenkins job created with Job DSL.')
    steps {
        shell('echo Hello, world!')
    }
}
