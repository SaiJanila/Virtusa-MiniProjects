import csv
from datetime import datetime

try:
    import matplotlib.pyplot as plt
    graph = True
except:
    graph = False

FILE_NAME = "expenses.csv"

# Create file if it doesn't exist
try:
    open(FILE_NAME, "r")
except FileNotFoundError:
    with open(FILE_NAME, "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(["Date", "Category", "Amount", "Description"])


# Add Expense
def add_expense():

    date = input("Enter Date (DD-MM-YYYY): ")

    try:
        datetime.strptime(date, "%d-%m-%Y")
    except:
        print("Invalid Date")
        return

    category = input("Enter Category: ")

    try:
        amount = float(input("Enter Amount: "))
    except:
        print("Invalid Amount")
        return

    description = input("Enter Description: ")

    with open(FILE_NAME, "a", newline="") as f:
        writer = csv.writer(f)
        writer.writerow([date, category, amount, description])

    print("Expense Added Successfully")


# View Expenses
def view_expenses():

    with open(FILE_NAME, "r") as f:

        reader = csv.reader(f)

        next(reader)

        print("\n------ Expenses ------")

        for row in reader:

            print("Date :", row[0])
            print("Category :", row[1])
            print("Amount :", row[2])
            print("Description :", row[3])
            print("------------------------")


# Monthly Summary
def monthly_summary():

    month = input("Enter Month (MM-YYYY): ")

    total = 0

    with open(FILE_NAME, "r") as f:

        reader = csv.reader(f)

        next(reader)

        for row in reader:

            if datetime.strptime(row[0], "%d-%m-%Y").strftime("%m-%Y") == month:

                total += float(row[2])

    print("\nTotal Expense :", total)
# Category Summary
def category_summary():

    categories = {}

    with open(FILE_NAME, "r") as f:

        reader = csv.reader(f)

        next(reader)

        for row in reader:

            categories[row[1]] = categories.get(row[1], 0) + float(row[2])

    print("\nCategory Summary")

    for c in categories:
        print(c, ":", categories[c])


# Highest Spending Category
def highest_category():

    categories = {}

    with open(FILE_NAME, "r") as f:

        reader = csv.reader(f)

        next(reader)

        for row in reader:

            categories[row[1]] = categories.get(row[1], 0) + float(row[2])

    if categories:

        highest = max(categories, key=categories.get)

        print("\nHighest Spending Category :", highest)
        print("Amount :", categories[highest])


# Spending Suggestion
def spending_suggestion():

    categories = {}

    with open(FILE_NAME, "r") as f:

        reader = csv.reader(f)

        next(reader)

        for row in reader:

            categories[row[1]] = categories.get(row[1], 0) + float(row[2])

    if categories:

        highest = max(categories, key=categories.get)

        print("\nSuggestion")

        if highest.lower() == "food":
            print("Reduce outside food expenses.")

        elif highest.lower() == "travel":
            print("Use public transport.")

        elif highest.lower() == "shopping":
            print("Avoid unnecessary shopping.")

        else:
            print("Plan your monthly budget.")

        if graph:

            plt.pie(categories.values(),
                    labels=categories.keys(),
                    autopct="%1.1f%%")

            plt.title("Expense Distribution")
            plt.show()


# Main Menu
while True:

    print("\n===== SMART EXPENSE TRACKER =====")
    print("1. Add Expense")
    print("2. View Expenses")
    print("3. Monthly Summary")
    print("4. Category Summary")
    print("5. Highest Spending Category")
    print("6. Spending Suggestion")
    print("7. Exit")

    choice = input("Enter Choice: ")

    if choice == "1":
        add_expense()

    elif choice == "2":
        view_expenses()

    elif choice == "3":
        monthly_summary()

    elif choice == "4":
        category_summary()

    elif choice == "5":
        highest_category()

    elif choice == "6":
        spending_suggestion()

    elif choice == "7":
        print("Thank You")
        break

    else:
        print("Invalid Choice")
