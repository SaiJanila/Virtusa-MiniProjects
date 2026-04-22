import csv

try:
    import matplotlib.pyplot as plt
    graph_ok = True
except:
    graph_ok = False

file_name = "my_expenses.csv"

# function to add new expense
def add_data():
    d = input("Enter date (YYYY-MM-DD): ")
    c = input("Enter category: ")
    a = float(input("Enter amount: "))
    note = input("Enter note: ")

    with open(file_name, "a", newline="") as f:
        writer = csv.writer(f)
        writer.writerow([d, c, a, note])

    print("Data saved")


# function to show monthly report
def show_report():
    month = input("Enter month (YYYY-MM): ")

    total_amt = 0
    category_data = {}

    try:
        with open(file_name, "r") as f:
            reader = csv.reader(f)

            for row in reader:
                d, c, a, note = row

                if d.startswith(month):
                    a = float(a)
                    total_amt += a

                    if c in category_data:
                        category_data[c] += a
                    else:
                        category_data[c] = a

        print("\nTotal spending:", total_amt)

        print("\nCategory details:")
        for key in category_data:
            print(key, "->", category_data[key])

        if category_data:
            max_cat = max(category_data, key=category_data.get)
            print("\nHighest spending:", max_cat)

            if category_data[max_cat] > 2000:
                print("You are spending more on", max_cat)

            # show graph only if matplotlib exists
            if graph_ok:
                plt.pie(category_data.values(), labels=category_data.keys(), autopct='%1.1f%%')
                plt.title("Expense Chart")
                plt.show()
            else:
                print("(Graph not available - matplotlib not installed)")

    except FileNotFoundError:
        print("No data found. Please add expenses first.")


# main menu
while True:
    print("\n1. Add Expense")
    print("2. Monthly Report")
    print("3. Exit")

    ch = input("Enter choice: ")

    if ch == "1":
        add_data()
    elif ch == "2":
        show_report()
    elif ch == "3":
        print("Program closed")
        break
    else:
        print("Invalid choice")
