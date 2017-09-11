package mail;

import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mails {
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

    public static void sendMail(String user, String password, String recipient, List<String> data) {
        String dataString = "";
        for (String s : data)
        {
            dataString += s + "\t";
        }
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("404 Links : ");
            message.setText(dataString);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void sendScreenshot(String user, String password, String recipient, Set<String> screenshots, String test) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject("Testing Subject");
            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<H1>Screenshots " + test + "</H1><img src=\"cid:image\">";
            messageBodyPart.setContent(htmlText, "text/html");
            multipart.addBodyPart(messageBodyPart);
            for(String screenshot : screenshots) {
                imgUpload(multipart, screenshot);
            }
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void imgUpload(Multipart multipart, String fileName) throws MessagingException
    {
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource(fileName);
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setFileName(getNameFromPath(fileName));
        multipart.addBodyPart(messageBodyPart);
    }


    public static String getNameFromPath(String path){
        return path.replace("src\\main\\java\\screenshots\\"  ,"").
                    replace(".jpg","");

    }
}
