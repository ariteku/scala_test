scalaVersion := "2.11.2"

val scalazVersion = "7.1.0"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "2.0.1",
  "com.h2database"  %  "h2"                % "1.4.178",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.2",
  "org.scalaz"      %% "scalaz-effect"     % scalazVersion,
  "org.scalaz"      %% "scalaz-core"       % scalazVersion,
  "org.specs2"      %% "specs2"            % "2.3.12" % "test",
  "com.chuusai"     %% "shapeless"         % "2.0.0",
  "org.apache.commons" % "commons-vfs2"    % "2.0"
)

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:higherKinds", "-language:implicitConversions")

initialCommands in console := "import scalaz._, Scalaz._"
