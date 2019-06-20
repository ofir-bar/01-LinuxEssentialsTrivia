package com.mobile.a01_linuxessentialstrivia.data

import com.mobile.a01_linuxessentialstrivia.model.Question

object QuestionsBank{

        private var questionsBank = listOf(
            Question("Which of the following can be used to access the command line?", listOf("Xargs", "XWindows", "BIOS", "Firefox", "Terminal")),
            Question("Which of the following is a Linux based operating system for use on mobile devices?", listOf("Android","CentOS", "IOS", "Debian")),
            Question("Where is the BIOS located?", listOf("RAM", "Motherboard", "Hard drive", "LCD Monitor")),
            Question("What is the number called that is used to identify a process?", listOf("Proc Num", "Process Entry", "PID", "PIN")),
            Question("Which of the following is a combined audio/video interface for transmission of digital data?", listOf("ATI", "DVI", "VGA", "HDMI", "DVD")),
            Question("Which of the following commands can be used to create a file?", listOf("Create", "Build", "Nico", "Touch", "Mkfile")),
            Question("Which of the following commands can be used to extract content from  a tar file?", listOf("Tar -v", "Tar -e", "Tar -c", "Tar -vf", "Tar -xvf")),
            Question("Which of the following commands can be used to extract files from an archive?", listOf("Tar -e", "Tar -evf", "Tar -vf", "Tar -v", "Tar -xvf")),
            Question("Which Linux distribution is used as a basis for the creation of Ubuntu Linux?", listOf("Gentoo Linux", "Red Hat Linux", "Arch Linux", "SUSE Linux", "Debian Linux")),
            Question("Which function does a shell program serve?", listOf("It provides a graphical environment", "It is responsible for logging a user into the system", "It is responsible for logging a user into the system", "It receives user commands and executes them"))
        )


    fun getInstanceAt(index: Int): Question{
        return questionsBank[index]
    }

    fun getInstance(): Collection<Question>{
        return questionsBank
    }

}
