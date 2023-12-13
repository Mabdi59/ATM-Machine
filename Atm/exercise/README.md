# ATM Application

## Overview

This ATM application simulates an Automated Teller Machine (ATM) system, allowing users to perform basic banking transactions like checking balances, making deposits, and withdrawals. It's built using Java and demonstrates object-oriented programming principles.

## Features

- **Authentication**: Verify users by card number and PIN.
- **Balance Inquiry**: Check the current balance of an account.
- **Deposit**: Deposit money into an account.
- **Withdrawal**: Withdraw money from an account.
- **Receipt Printing**: Print transaction receipts (simulated).

## Project Structure

- `com.MohamedAbdi.bank`: Contains classes related to banking operations (e.g., `Account`, `BankDatabase`).
- `com.MohamedAbdi.AtmHardware`: Simulates ATM hardware components like `CardReader`, `CashDispenser`, `Printer`.
- `com.MohamedAbdi.Security`: Manages security aspects, including user authentication.
- `com.MohamedAbdi.userinterface`: Handles user interaction with the ATM.
- `com.MohamedAbdi.Util`: Provides utility classes such as `Logger` and `Configuration`.
- `com.MohamedAbdi.main`: Contains the `Main` class which is the entry point of the application.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher.
- Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse.

### Setup

1. **Clone the Repository**: Clone or download the project repository to your local machine.
   git clone https://github.com/your-username/your-repo-name.git
2. **Open Project**: Open the project in your preferred IDE.

3. **Configuration**: Edit the `config.txt` file in the resources to adjust application settings.

### Running the Application

1. **Compile the Code**: Use your IDE's build tool to compile the project.

2. **Run the Main Class**: Run the `Main` class located in the `com.MohamedAbdi.main` package.

3. **Interact with the ATM**: Follow the on-screen prompts to perform banking transactions.

## Usage

After starting the application, follow these steps:

1. Enter a valid card number (e.g., `123456789`).
2. Enter the corresponding PIN (e.g., `1738` for the card number above).
3. Choose the desired transaction (e.g., Check Balance, Withdraw).
4. Follow the prompts to complete the transaction.

## Contributing

To contribute to this project:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a pull request.

## Contact

moha.abdi105@gmail.com

Project Link: [https://github.com/your-username/your-repo-name](https://github.com/your-username/your-repo-name)