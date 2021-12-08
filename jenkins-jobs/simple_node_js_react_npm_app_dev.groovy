folder("jcasc") {
}
pipelineJob("jcasc/simple-node-js-react-npm-app-dev") {
    description("Build and deploy demo service from develop branch on development environment.")
    keepDependencies(false)
    disabled(false)
    concurrentBuild(false)
    logRotator {
        numToKeep(500)
        daysToKeep(30)
    }
    definition {
        cpsScm {
            scm {
                git  {
                    branch('*/master')
                    remote {
                        credentials 'git-credentials'
                        url('https://github.com/banshee77/simple-node-js-react-npm-app.git')
                    }
                }
            }
            scriptPath('Jenkinsfile.dev')
        }
    }
    triggers {
        scm('H/5 * * * *') {
            ignorePostCommitHooks(false)
        }
    }
}