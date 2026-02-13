<h1> DEPENDÊNCIAS </h1>

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
			<artifactId>spring-boot-starter-flyway</artifactId>
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

<h1> MOLDES DAS CLASSES </h1>


<h2> PARA CRIAR CONTROLLERS </h2>

	@RestController
	@RequestMapping
	public class NomeDaClasse {

		// Mostrar tudo (READ)
    	@GetMapping("/readAll")
    	public List<ExemploModel> mostrarTodosOsDados(){
        return exemploService.listarTodosOsDados();
    	}
		
	}

<h2> PARA CRIAR MODELS </h2>
 
// usando a dependência lombok

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

<h2> PARA CRIAR REPOSITORIES </h2>

//JpaRepository -> "facilitador" semelhante ao lombok <br>
// 1 atributo -> classe a ser escaneada <br>
// 2 atributo -> tipo de dado do ID da classe escaneada // exemplo: Long <br>

	public interface FuncaoRepository extends JpaRepository<ClasseExemploModel, Long> {
	}

<h1> PARA CRIAR SERVICES </h1>

	@Service
	public class ExemploService{
	
		// Injetar o repositório para acessar os dados
		private ExemploRepository exemploRepository;

		// Construtor
		public ExemploService(ExemploRepository exemploRepository) {
			this.exemploRepository = exemploRepository;
		}

		//Listar todos os dados
    	public List<ExemploModel> listarTodosOsDados() {
        return exemploRepository.findAll();
    	}
	}
	
	

	
<h1> APPLICATION.PROPERTIES </h1>

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

	#Configurações do flyway
	spring.flyway.enabled=true
	spring.flyway.locations=classpath:db/migration
	spring.flyway.baseline-on-migrate=true
<h1> .ENV </h1>
// PASSAR ESSE ARQUIVO NAS CONFIGURAÇÕES DE VARIÁVEIS DE AMBIENTE

	DATABASE_URL=jdbc:h2:file:./data/projectDB
	DATABASE_USERNAME=
	DATABASE_PASSWORD=

<h1> .GITIGNORE </h1>

	.env
	data/

<h1> REPOSITÓRIO BANCO DE DADOS </h1>
// EXEMPLO DE COMO DEVE FICAR O REPOSITÓRIO DO BANCO DE DADOS

	resources
		|
		--> db
			 |
			 --> migration
			 	     |
					 --> V2__Add_nomeDaAlteracao.sql
					 |
					 --> V3__Add_nomeDaAlteracao.sql
					 |
					 --> V4__Add_nomeDaAlteracao.sql
