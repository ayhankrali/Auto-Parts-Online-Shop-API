# Auto-Parts-Online-Shop-API

# Auto Parts Online Shop API 🚀💻

Welcome to the pinnacle of auto parts innovation—the **Auto Parts Online API**! 🌟 This cutting-edge RESTful API is engineered to redefine the online auto parts shopping experience. Fueled by Java, Maven, MySQL, Spring Boot, Hibernate, Lombok, and fortified with Spring Security and JWT for a secure and seamless journey.

## Key Features 🏎️

### Entities with Flair 🌐
- **Part Category**: Explore a universe of auto parts, each category boasting id, name, and description.
- **Part**: Unleash the intricacies of auto parts—id, name, description, and price—all meticulously designed.
- **Make**: Dive into the world of manufacturers with id and name.
- **Model**: Witness the beauty of car models, each defined by a unique id and name.

### Dynamic Relationships 🚗💨
- A Part seamlessly aligns with a Category in a one-to-many dance.
- A Model finds its essence under a single Make through a captivating one-to-many relationship.
- Part and Model harmonize in a captivating many-to-many relationship.

### Thrilling API Endpoints 🔧
- **GET /makes**: Embark on a curated journey through manufacturers.
- **GET /models/{make?}**: Unearth car models, optionally filtered by their illustrious manufacturers.
- **GET /parts**: Immerse yourself in a treasure trove of auto parts.
- **GET /parts/{id}**: Dive deep into the soul of a specific part, revealing compatibility listings.
- **GET /parts/{category}/{model?}**: Explore parts in a specific category, optionally harmonizing with a chosen auto model.
- **GET /parts/search?name={name}**: Thrilling quest for parts across all categories, fueled by a resonating name.

### Empowering Administrative Zenith 🔱
- **GET /makes/{id}**: Plunge into the details of a specific make.
- **GET /models/{id}**: Uncover the essence of a car model.
- **POST /makes**: Witness the birth of a new manufacturer.
- **POST /models**: Contribute to the evolution of car models.
- **PUT /makes/{id}**: Sculpt an existing car make into perfection.
- **PUT /models/{id}**: Fine-tune a car model with precision.
- **DELETE /makes/{id}**: Bid farewell to a manufacturer.
- **DELETE /models/{id}**: Remove a car model gracefully.
- **POST /parts**: Infuse new life into the world of auto parts.
- **PUT /parts/{id}**: Elevate an existing part, transcending limits with enhanced compatibility.
- **DELETE /parts/{id}**: Retire a part gracefully.

### Authentication Mastery 🔐
- **POST /auth/signup**: Initiate your journey with a user registration experience defined by elegance.
- **POST /auth/login**: Unlock the doors with user authentication, unveiling a bespoke JWT token. Fortified security, requiring authentication and validating JWT tokens.

### Art of Persistence and Elegance 🎨
- Hibernate orchestrates data persistence to a MySQL database for optimal performance. Meticulously crafted database schema for scalability—a canvas for automotive excellence.

### Streamlined Development with Lombok 🚀
- Lombok takes center stage, reducing boilerplate code, ensuring a clean, concise, and masterful codebase.

### Rigorous Testing in the Forge of Excellence 🛠️🧪
- API is battle-tested with comprehensive unit tests, ensuring reliability and perfection. Testing framework of choice: [ JUnit, Mockito].

## Join the Apex Revolution 🌟
Feel the heartbeat of innovation, contribute to the future, and revel in the brilliance of the Auto Parts Online API. Your journey into the world of online auto parts has never been more thrilling! 🚗💨
