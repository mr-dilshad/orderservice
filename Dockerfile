# Use the official MySQL image from the Docker Hub
FROM mysql:8.0

# Set environment variables
# These will be used to set up the database
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=my_database
ENV MYSQL_USER=my_user
ENV MYSQL_PASSWORD=my_password

# Expose the port on which MySQL will run
EXPOSE 3306

# Optionally, you can add custom SQL scripts to initialize your database
# COPY ./my_init_script.sql /docker-entrypoint-initdb.d/

# By default, the image will run MySQL server as its entrypoint
