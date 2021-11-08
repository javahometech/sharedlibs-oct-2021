def call(conf){
  def repoName = conf["repoName"]
  def pomFile = readMavenPom file: 'pom.xml'
  def version = pomFile.version
  def artifactId = pomFile.artifactId
  def type = pomFile.packaging
  def groupId = pomFile.groupId
  nexusArtifactUploader artifacts: [[artifactId: "${artifactId}", classifier: '', file: "target/${artifactId}-${version}.war", type: type]], credentialsId: 'nexus3', groupId: groupId, nexusUrl: '54.206.50.199:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: repoName, version: "${version}"
}
