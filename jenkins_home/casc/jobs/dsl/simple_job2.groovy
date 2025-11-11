job('simple-job-2') {
    description('This is a simple Jenkins job created with Job DSL.')
    steps {
        shell('echo Hello, world!')
    }
}
