package com.mobile.a01_linuxessentialstrivia.data

import com.mobile.a01_linuxessentialstrivia.model.Question

object QuestionsBank{

        private var questionsBank = listOf(
            Question("Which of the following can be used to access the command line?", listOf("Xargs", "BIOS", "Firefox", "Terminal"), 3),
            Question("Which of the following is a Linux based operating system for use on mobile devices?", listOf("Android","CentOS", "IOS", "Debian"), 0),
            Question("Where is the BIOS located?", listOf("RAM", "Hard Drive", "Motherboard", "LCD Monitor"), 2),
            Question("What is the number called that is used to identify a process?", listOf("Proc Num", "Process Entry", "PID", "PIN"), 2),
            Question("Which of the following is a combined audio/video interface for transmission of digital data?", listOf("ATI", "DVI", "VGA", "HDMI"), 3),
            Question("Which of the following commands can be used to create a file?", listOf("Create", "Build", "Nico", "Touch"), 3),
            Question("Which of the following commands can be used to extract content from  a tar file?", listOf("Tar -v", "Tar -e", "Tar -c", "Tar -xvf"), 3),
            Question("Which of the following commands can be used to extract files from an archive?", listOf("Tar -e", "Tar -xvf", "Tar -vf", "Tar -v"), 1),
            Question("Which Linux distribution is used as a basis for the creation of Ubuntu Linux?", listOf("Debian Linux", "Red Hat Linux", "Arch Linux", "SUSE Linux"), 0),
            Question("Which function does a shell program serve?", listOf("It provides a graphical environment", "It is responsible for logging a user into the system", "It is responsible for logging a user into the system", "It receives user commands and executes them"), 3)
        )

    fun getInstanceAt(index: Int): Question{
        return questionsBank[index]
    }

    fun getInstance(): Collection<Question>{
        return questionsBank
    }

}
