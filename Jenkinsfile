pipeline{
    agent any
    tools{
        jdk 'JDK17'
    }
    triggers{
        cron('H/30 * * * *')
    }
    stages{
        stage('Checkout'){
            steps{
                git branch: 'main' url= 'https://github.com/pradeepTechStream/Rest_Mongo_Docker.git'
            }
        }
        stage('build'){
             steps{
                bat 'mvn clean install'
             }
        }
        stage('test'){
             steps{
                bat 'mvn test'
             }
        }
    }
    post{
        success{
            echo 'Build and deployment success'
        }
        failure{
            echo 'Build fail.'
        }
    }
}