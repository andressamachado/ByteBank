import java.awt.Container

fun main() {
    val account01 = Account("Andressa", 1)
    account01.deposit(2000.0)
    account01.withdraw(1000.0)

    val account02 = Account("Omar", 2)
    account02.deposit(1500.0)
    account02.withdraw(500.0)

    //Reference
    val account03 = account01
    println(account03)
    println(account01)

    println()

    //println("Welcome to the ByteBank " + accountHolder)
    println("Welcome to the ByteBank ${account01.accountHolder}. ")
    println("Account number: ${account01.accountNumber}")
    println("Balance: ${account01.balance}")
    println(account01)

    println()

    println("Welcome to the ByteBank ${account02.accountHolder}. ")
    println("Account number: ${account02.accountNumber}")
    println("Balance: ${account02.balance}")
    println(account02)

    println()

    if (account01.transfer(account02, 1000.0)) {
        println("Transfer completed")
        println("${account01.accountHolder}`s account balance: ${account01.balance}")
        println("${account02.accountHolder}`s account balance: ${account02.balance}")
    } else {
        println("Transfer denied")
    }


    //FOR LOOP:

    //Starts in 5 and goes down to 1 counting by 2
    //for(i in 5 downTo 1 step 2) {
    //  if(i == 4){ break } }

    //loop@ for (i in 1..100) {
    //  println("i $i")
    //  for (j in 1..100) {
    //      println("j $j")
    //      if (j == 5) break@loop
    //  }
    //}
}

//primary constructor, as we would pass parameters to a class
class Account(var accountHolder: String, var accountNumber: Int) {
    //must initialize the variable as soon as it is declared if type is not specified
    //val accountHolder = "Andressa"
    //var = General variable. Mutable and can be assigned multiple times.
    //val = Final variable. Immutable and can be initialized only single time.
    var balance: Double = 0.0
        //Kotlin offers a default getter and setter, we can define custom accessor for a property
        //and it will be called every time we access the property
        //set(amount){
        //  field receives the value internally. If we print the
        //  value of the field it will print 0.0 at this point
        //  we can then handle the value to be assign to the balance
        //  if (amount > 0) {
        //      field = amount
        //   }
        //}
        //One way to restrict the access to the variable is to set its setter to be private:
        //only this class can modify the value of the variable
        private set

    fun deposit(amount: Double) {
        if (amount > 0) {
            this.balance += amount
        }
    }

    //Like void in Java, Unit is the return type of any function that does not return any meaningful value in Kotlin
    fun withdraw(amount: Double): Unit {
        if (balance >= amount) {
            this.balance -= amount
        }
    }

    fun transfer(recipient: Account, amount: Double): Boolean {
        if (balance >= amount) {
            balance -= amount
            recipient.deposit(amount)
            return true
        }

        return false
    }
}

fun balanceStatus(balance: Double) {
    //if statement can be replaced with when
    when {
        balance > 0.0 -> println("positive balance")
        balance == 0.0 -> println("balance")
        else -> println("negative balance")
    }
}