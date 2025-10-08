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
            steps(){
                git branch: 'main' url
            }

        }
    }
}