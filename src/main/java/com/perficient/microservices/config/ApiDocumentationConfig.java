package com.perficient.microservices.config;

import io.swagger.annotations.Contact;
//import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "ABC Telecom",
                version = "V1",
                title = "ABC Telecom API",
                contact = @Contact(
                   name = "Perficient", 
                   email = "GDCChennai_Javasb@perficient.com", 
                   url = "https://www.perficient.com/"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
        
)
public interface ApiDocumentationConfig {

}