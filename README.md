# Library Management System

A Java-based console application that manages a library's books and users, and handles book loans. This project implements object-oriented principles, including inheritance, abstraction, interfaces, and polymorphism, to provide a clean and modular design. The system allows users to add books, manage users, loan books, return books, and track loan details.

## Features

- **Add and Remove Books**: Support for adding and removing different types of books (e.g., Novels, Textbooks, Reference Books).
- **Manage Users**: The system manages three types of users: Students, Faculty, and Public Members, each with specific loan limits.
- **Loan System**: Books can be loaned to users, with different loan fees calculated based on the type of book and loan duration.
- **Return Books**: Users can return loaned books, and late fees are applied based on the number of days overdue.
- **Loan Tracking**: Track the books loaned to users and calculate total loan fees.
- **Extend Loans**: Implements an interface (`Loanable`) that defines whether items can be loaned and whether loans can be extended.

## Classes

### Main Classes
- **`Library`**: Manages the collection of books and users, handles loans and returns.
- **`User`** (Abstract): Represents a library user, with subclasses for Students, Faculty, and Public Members, each with different loan limits.
- **`Book`** (Abstract): Represents a book, with subclasses for specific types (Novel, TextBook, ReferenceBook).

### Subclasses of `Book`
- **`Novel`**: Represents a novel and calculates a base loan fee.
- **`TextBook`**: Represents a textbook and supports additional logic for loan calculations.
- **`ReferenceBook`**: Represents a reference book, usually non-loanable.

### Subclasses of `User`
- **`Student`**: Represents a student user with a specific loan limit.
- **`Faculty`**: Represents a faculty member with a higher loan limit.
- **`PublicMember`**: Represents a public member with a fixed base loan fee and lower loan limit.

### Interface
- **`Loanable`**: Defines methods related to loan operations, such as calculating the loan fee, checking availability, and whether a loan can be extended.
  
## Prerequisites
- **Java Development Kit (JDK)**: Make sure you have JDK 8 or later installed.
- **IDE**: You can use any IDE, such as IntelliJ IDEA, Eclipse, or VS Code with Java extensions.

## Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue if you find a bug or want to suggest improvements.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
