scalaVersion := "2.11.0"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "2.0.1",
  "com.h2database"  %  "h2"                % "1.4.178",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.2",
  "org.scalaz"      %% "scalaz-core"       % "7.0.6",
  "org.specs2"      %% "specs2"            % "2.3.12" % "test"
)

