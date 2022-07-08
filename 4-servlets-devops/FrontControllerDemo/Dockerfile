# The first thing we'll need is the FROM command
# The FROM command initialiazes a new build stage and sets the Base Image for subsequent instructions
FROM tomcat:8.0-jre8

# The ADD instruction copies new files, directories, or remote file URLS from <src>
# and adds them to the filesystem of the image at the path <dest>
ADD target/FrontControllerDemo.war /usr/local/tomcat/webapps/

# Now, we'll use the EXPOSE instruction to inform Docker that the container listens on the specificed
# network ports at runtime
EXPOSE 8080

# The CMD instruction specifies what to do when the container (not the image) is run
# In our case, TomCat server is started by running the shell script that starts the web
# container. There can only be one CMD instruction in a Dockerfile.
# Do not confuse RUN with CMD. RUN actually runs the command at build time
CMD ["catalina.sh", "run"]