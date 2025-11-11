job('simple-job-3') {
    description('This is a simple Jenkins job created with Job DSL.')
    steps {
        shell('echo Hello, world!')
    }
}
