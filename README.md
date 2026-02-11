-=-=-=-=-=-=-=-=-=-=-=-=-= DEPENDÊNCIAS -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
<dependencies>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webmvc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webmvc-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-h2console</artifactId>
		</dependency>
    
</dependencies>

-=-=-=-=-=-=-=-=-=-=-=-=- MOLDES DAS CLASSES -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


<><><><><><><><><><><><> PARA CRIAR CONTROLLERS <><><><><><><><><><>><><><><><><><><>
<code>
@RestController
@RequestMapping
public class NomeDaClasse {
	
	@GetMapping("/nomedarota") // -> localhost:8080/nomedarota

}
</code>
<><><><><><><><><><><><> PARA CRIAR MODELS <><><><><><><><><><><><><><><><><><><><><>
 
// usando a dependência lombok
<code>
@NoArgsConstructor // -> cria o construtor da classe, sem argumentos
@AllArgsConstructor // -> cria o construtor da classe, com todos os argumentos
@Data // -> cria os Getters & Setters

@Entity // -> Transforma a classe em uma entidade do banco de dados
@Table(name = "tb_nomeDaTabela") // -> "tb" vem de "table"
public class NomeDaClasseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.)
	@Column(name = "nomeDaColuna")
	private Long id;

	@Column(name= "nomeDaColunaUnica", unique = true) // não permite elementos duplicados
	private String email; // exemplo de dado não duplicado

	@ManyToOne // vários para um
	@OneToMany // um para vários
	@JoinColumn(name = "chaveEstrangeira") // cria uma coluna que será a chave estrangeira, para interligar tabelas
	private OutraClasseModel outraClasse; // pega o elemento da outra classe

}
</code>
<><><><><><><><><><><><> PARA INICIAR O JPA <><><><><><><><><><><><><><><><><><><><><>

//JpaRepository -> "facilitador" semelhante ao lombok <br>
// 1 atributo -> classe a ser escaneada <br>
// 2 atributo -> tipo de dado do ID da classe escaneada // exemplo: Long <br>
<code>
public interface FuncaoRepository extends JpaRepository<ClasseExemploModel, Long> {
}
</code>
-=-=-=-=-=-=-=-=-=-=-=-=-= APPLICATION.PROPERTIES -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
<code>
#Configurações do banco de dados
spring.datasource.url=${DATABASE_URL}
spring.datasource.driverClassName=${DATABASE_DRIVER}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
DB_CLOSE_DELAY=-1
DB_CLOSE_ON_EXIT=FALSE
AUTO_SERVER=TRUE

#Configurações do JPA // HIBERNATE
spring.h2.console.enabled=true // habilita o console do h2
SPRING.jpa.hibernate.ddl-auto=update 
spring.jpa.show-sql=true
</code>
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= .ENV -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// PASSAR ESSE ARQUIVO NAS CONFIGURAÇÕES DE VARIÁVEIS DE AMBIENTE
<code>
DATABASE_URL=jdbc:h2:file:./data/projectDB
DATABASE_USERNAME=
DATABASE_PASSWORD=
</code>
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= .GITIGNORE -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
<code>
.env
data/
</code>
