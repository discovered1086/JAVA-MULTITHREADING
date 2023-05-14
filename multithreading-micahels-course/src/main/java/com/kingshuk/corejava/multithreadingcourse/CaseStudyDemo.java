package com.kingshuk.corejava.multithreadingcourse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

public class CaseStudyDemo {

    public static final String THREAD_RUNNING = "The thread that's running is: ";

    public static void main(String[] args) {
        Vault vault = new Vault("Iofdtiger@16");

        Arrays.asList(new BetterHackerThread(vault),
                new WorseHackerThread(vault),
                new PoliceThread()).forEach(Thread::start);


    }

    @AllArgsConstructor
    private static class Vault {
        private String password;

        public boolean isPasswordCorrect(String guess) {
            return this.password.equals(guess);
        }
    }


    @Getter
    private abstract static class HackerThread extends Thread {
        private Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(MAX_PRIORITY);
        }

        @Override
        public synchronized void start() {
            super.start();
            System.out.println("Staring thread: " + this.getName());
        }

        public void logHackingStatus(String password) {
            if (this.vault.isPasswordCorrect(password)) {
                System.out.println("The password: " + password + " is correct and has been" +
                        " guessed by " + this.getName());
                System.exit(0);
            }
        }
    }

    private static class BetterHackerThread extends HackerThread {
        private final List<String> passwords = Arrays.asList("Iofdtiger#16", "Iofdtiger16",
                "Iofdtiger@16","Eyeofdtiger#16", "Eyeofthetiger#16");

        public BetterHackerThread(Vault vault) {
            super(vault);
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(THREAD_RUNNING + this.getName());
            for (String password : passwords) {
                Thread.sleep(3000);
                logHackingStatus(password);
            }
        }
    }

    private static class WorseHackerThread extends HackerThread {
        private final List<String> passwords = Arrays.asList("ahjgsddhsfgh#16", "54545",
                "sdfsfsdf#16", "ioeyfuyuihfufuh#16");

        public WorseHackerThread(Vault vault) {
            super(vault);
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(THREAD_RUNNING + this.getName());
            for (String password : passwords) {
                Thread.sleep(5000);
                logHackingStatus(password);
            }
        }
    }

    private static class PoliceThread extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            System.out.println(THREAD_RUNNING + this.getName());

            for (int i = 10; i >= 0; i--) {
                Thread.sleep(1000);
                System.out.println("Seconds left before Police arrives: " + i);
            }

            System.out.println("Game over for you hacker...!!");
            System.exit(0);
        }
    }
}
