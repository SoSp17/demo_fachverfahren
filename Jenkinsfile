pipeline{
    agent any
    tools{
    /*Hier Build Tool mit entsprechender Version einfügen*/
    maven 'apache-maven-3.8.3'
    } 
        environment {
        // This can be nexus3 or nexus2
        NEXUS_VERSION = "nexus3"
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running
        NEXUS_URL = "localhost:8081"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY = "DemoFachverfahren-SNAPSHOT"
        // Jenkins credential id to authenticate to Nexus OSS
        NEXUS_CREDENTIAL_ID = "Nexus2"
        
        NEXUS_DOCKER="localhost:2222/repository/fachverfahren-docker"
        IMAGE = readMavenPom().getArtifactId()
        VERSION = readMavenPom().getVersion()
        CONTAINER_TAG="latest"
        
       
    }  

    stages{


    
		stage("checkout"){
            steps{
        	echo'checking out'
        	/*checkout scm, Code im Snippet Generator Generiert */
        	checkout([$class: 'GitSCM', branches: [[name: '*/*']], extensions: [], userRemoteConfigs: [[url: '/home/user/git/demo_fachverfahren/']]])
            }
        }
        
        stage("build"){
            steps{
        echo'building'
        /*mit dem Präfix sh kommt hier der Shell befehl der benötigt wird um den Build auszuführen*/
        sh 'mvn clean compile'
            }
        }
        
        stage("Unittest"){
            steps{
        	echo'testing'
        	sh 'mvn test'
 			junit '**/target/surefire-reports/TEST-*.xml'
 			/*der Dateipfad kann hier angepasst werden ,jenachdem wo die Testergebnisse liegen*/     
 			}

        }
        stage("Checkstyle"){
            steps{
            /*Checkstyle analyse*/
                sh'mvn site'
                recordIssues(tools: [checkStyle(pattern: '**/target/checkstyle-result.xml')])
             /*   recordIssues(tools: [checkStyle(reportEncoding: 'UTF-8')])*/
            }

        }

        
        /*Code um die SoanrQube anlyse anzustossen*/
        stage("SonarQube Analysis") {
        	steps{
        	withSonarQubeEnv('SonarQube') {
        	/*SonarQube ist der Name der in Jenkins für die SonarQube Instanz vergeben wurde*/ 
        	sh "mvn clean verify sonar:sonar "
        		}
        	}
        }
     /*   stage("Seleniumtest"){*/
     /*       steps{*/
     /*           sh "mvn clean install"  */         
     /*       }*/
     /*   post {*/
    /*	always {*/
      /*	step([$class: 'Publisher', reportFilenamePattern: '** /testng-results.xml'])*/
    /*		}*/
    /*	}*/
            
     /*   }*/


        
        stage("Publish to Nexus"){
        	steps{
        	echo'publishing'
 
        	                script {
                    // Read POM xml file using 'readMavenPom' step , this step 'readMavenPom' is included in: https://plugins.jenkins.io/pipeline-utility-steps
                    pom = readMavenPom file: "pom.xml";
                    // Find built artifact under target folder
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    // Print some info from the artifact found
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    // Extract the path from the File found
                    artifactPath = filesByGlob[0].path;
                    // Assign to a boolean response verifying If the artifact name exists
                    artifactExists = fileExists artifactPath;

                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";

                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                // Artifact generated such as .jar, .ear and .war files.
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],

                                // Lets upload the pom.xml file for additional information for Transitive dependencies
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );

                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        	}
        stage("Build Docker Image"){
            steps{
                   withCredentials([usernamePassword(credentialsId: 'Nexus2', passwordVariable: 'PASS', usernameVariable: 'USER')])  {
                               /*args an dockerfile übergeben und das image damit erstellen*/
            echo "Building image ${IMAGE}:${VERSION}..."
                            /*  vor dem : steht der name des repositories    */ 
                /*aus dem Dockefile wird ein bild gebaut und getaggt*/     
         /*   sh ' docker build -t ${NEXUS_DOCKER}:latest .'*/
			echo"loggin in nexus"
                   
           	/*docker muss sich bei dem Port anmelden der im Repository agegeben ist*/
		/*	sh'docker login -u ${USER} -p ${PASS} localhost:1111'*/

            echo"uploading image.."
		/*	sh' docker push ${NEXUS_DOCKER}:latest'*/
            
                }
            }
		}
		stage("Scan Docker Image"){
		steps{

			echo "Snyk analyse"
			snykSecurity failOnError: false, failOnIssues: false, snykInstallation: 'Snyk', snykTokenId: 'spies17'
			
			
		}

		}
            
    }
 }

        
        
  
