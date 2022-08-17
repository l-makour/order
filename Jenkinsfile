node {
    stage ("checkout") {
        checkout([$class: 'GitSCM', branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/l-makour/order.git']]])
    }
    stage ("Unit Tests"){
        sh "chmod 777 ./mvnw && ./mvnw test"
    }
    stage ("Integration Tests"){
        sh "chmod 777 ./mvnw && ./mvnw test -P failsafe"
    }
    stage ("packaging"){
        sh "chmod 777 ./mvnw && ./mvnw package"
    }
    stage ("Copie des livrables"){
        stash includes: 'Dockerfile', name: 'Dockerfile'
        stash includes: 'target/*.jar', name: 'Livrable'
    }

    node("VM-Integration") {

        stage ("Unstash des livrables"){
            unstash 'Livrable'
            unstash 'Dockerfile'
        }
        sh "pwd && ls -ltr"

        stage("build image"){
          sh "sudo docker build -t hsdahmane/orders:1.0 ."
        }
        stage("push image"){
            sh "sudo docker login -u hsdahmane -p Fayçal@2022"
            sh " sudo docker push hsdahmane/orders:1.0 "
        }
        stage("deploiement"){
            try{
                sh "sudo docker stop orders"
                sh "sudo docker rm orders"
                sh "sudo docker run --name orders -d -p 8082:8089 hsdahmane/orders:1.0"
            }
            catch(Exception e){
                sh "sudo docker run --name orders -d -p 8082:8089 hsdahmane/orders:1.0"
            }
        }
    }
}