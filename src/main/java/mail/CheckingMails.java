package mail;

import java.util.Properties;

import javax.mail.*;

public class CheckingMails {
    public static String check(String host, String storeType, String user, String password) {
        String returnStr = "";
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, user, password);
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);
            System.out.println("---------------------------------");
            System.out.println("Subject: " + messages[0].getSubject());
            System.out.println("From: " + messages[0].getFrom()[0]);
            String text = messages[0].getContent().toString();
            System.out.println(text);
            String[] lines = text.split("\"");
            for (int i = 0; i <= lines.length - 1; i++) {
                if (lines[i].contains("https://avmg.com.ua/user/info/?change_password=yes")) {
                    returnStr = lines[i];
                    System.out.println("dddddddd" + returnStr);
                    break;
                }
            }
            //messages[0].setFlag(Flags.Flag.DELETED, true);
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnStr;
    }

    public static String deleteAllMail(String host, String storeType, String user, String password) {
        String returmStr = "";
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, user, password);
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);
            Message[] messages = emailFolder.getMessages();
            for (int i = 0; i <= messages.length - 1; i++) {
                messages[i].setFlag(Flags.Flag.DELETED, true);
            }
            emailFolder.close(true);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returmStr;
    }

    public static String confirmMail(String host, String storeType, String user, String password, String mask1, String mask2) {
        String returnStr = "";
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, user, password);
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            Message[] messages = emailFolder.getMessages();
            System.out.println(messages.length);
            for (int i = messages.length - 1; i>=0; i--){
                System.out.println(i);
                String text = messages[i].getContent().toString();
                if (text.contains(mask1)) {
                    System.out.println(text);
                    String[] lines = text.split("\"");
                    for (int j = 0; j <= lines.length - 1; j++) {
                        if (lines[j].contains(mask2)) {
                            returnStr = lines[j];
                            System.out.println(returnStr);
                            break;
                        }
                    }
                }
            }
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnStr;
    }

    public static void waitMail(String host, String storeType, String user, String password) {
        boolean flag = true;
        int i = 80;
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        while ((flag) && (i!=0)) {
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, user, password);
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            Message[] messages = emailFolder.getMessages();
                if (messages.length >0)
                    flag = false;
            emailFolder.close(false);
            store.close();
            Thread.sleep(400);
            i--;
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
}
