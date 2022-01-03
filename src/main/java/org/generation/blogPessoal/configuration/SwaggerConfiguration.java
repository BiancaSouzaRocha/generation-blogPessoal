package org.generation.blogPessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
class SwaggerConfiguration {

	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Blog Pessoal").description("Projeto realizado na Generation Brasil")
						.version("v1")
						.license(new License().name("Generation Brasil").url("https://brazil.generation.org/"))
						.contact(new Contact().name("Github Bianca").url("https://github.com/BiancaSouzaRocha")
								.email("biancasouzarocha@outlook.com")))
				.externalDocs(new ExternalDocumentation().description("Github Blog Pessoal")
						.url("https://github.com/BiancaSouzaRocha/generation-blogPessoal"));

	}

	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}

	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
		return openApi -> {
			openApi.getPaths().values().forEach(PathItem -> PathItem.readOperations().forEach(operation -> {

				ApiResponses api = operation.getResponses();

				api.addApiResponse("200", createApiResponse("Sucesso!"));
				api.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				api.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				api.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				api.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				api.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				api.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
			}));
		};
	}

	
}
