pipeline{
    agent{
        label "jenkins-agent"
    }
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }
    stages{
        stage("Cleanup Workspace"){
            steps {
                cleanWs()
            }

        }
    
        stage("Checkout from SCM"){
            steps {
                git branch: 'main', credentialsId: 'github', url: 'https://github.com/k-uday-1804/SpBtAng.git'
            }

        }
        stage('Database Query') {
            steps {
                 script {
                    def result = sql jdbcUrl: 'jdbc:mysql://18.224.228.225:3306/your_database',
                            driver: 'com.mysql.cj.jdbc.Driver',
                            credentialsId: 'your_database_credentials',
                            query: 'SELECT * FROM your_table'
                 echo result
        }
    }
}
        stage("Build Application"){
            steps {
                sh "mvn clean package"
            }

        }

        stage("Test Application"){
            steps {
                sh "mvn test"
            }

        }
    }
}