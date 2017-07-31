package selector;

import com.sun.javafx.collections.MappingChange;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by Дмитрий on 17.07.2017.
 */
public  class selectors {

    public static  Map<String, By> getSelectors(String url) throws InterruptedException {
        Map<String , By> fieldBy = new HashMap<String , By>() {{
            switch (url) {
                case ("https://ru.avmg.com.ua"):
                        put("name", By.cssSelector("input[name=\"form_text_135\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_136\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_137\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_138\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_139\"]"));
                        put("town", By.cssSelector("input[name=\"form_text_141\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_140\"]"));
                        put("idform", By.className("av-form-index"));
                        break;

                case ("https://ru.avmg.com.ua/contacts/"):
                        put("name", By.cssSelector("input[name=\"form_text_135\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_136\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_137\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_138\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_139\"]"));
                        put("town", By.cssSelector("input[name=\"form_text_141\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_140\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://ru.avmg.com.ua/uslugi/gazovaya-rezka-metalla/"):
                        put("name", By.cssSelector("input[name=\"form_text_73\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_74\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_107\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_108\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_109\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_110\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://ru.avmg.com.ua/uslugi/rezka-na-lentopilnom-stanke/"):
                        put("name", By.cssSelector("input[name=\"form_text_117\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_118\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_119\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_120\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_121\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_122\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://ru.avmg.com.ua/uslugi/plazmennaya-rezka-metalla/"):
                        put("name", By.cssSelector("input[name=\"form_text_111\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_112\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_113\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_114\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_115\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_116\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://ru.avmg.com.ua/uslugi/prodolnaya-rezka-metalla/"):
                        put("name", By.cssSelector("input[name=\"form_text_123\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_124\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_125\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_126\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_127\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_128\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://ru.avmg.com.ua/uslugi/dostavka/"):
                        put("name", By.cssSelector("input[name=\"form_text_129\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_130\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_131\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_132\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_133\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_134\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://ru.avmg.com.ua/about/partnersavmg/"):
                        put("companyName", By.cssSelector("input[name=\"form_text_88\"]"));
                        put("legalAdress", By.cssSelector("input[name=\"form_text_89\"]"));
                        put("town", By.cssSelector("input[name=\"form_text_90\"]"));
                        put("postalIndex", By.cssSelector("input[name=\"form_text_91\"]"));
                        put("legalStatus", By.xpath("//label[text()=\"СПД (ФЛП)\"]"));
                        put("addressForDeliveryOfDocuments", By.cssSelector("input[name=\"form_text_94\"]"));
                        put("placeOfdelivery", By.cssSelector("input[name=\"form_text_95\"]"));
                        put("postalCodeOfDelivery", By.cssSelector("input[name=\"form_text_96\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_97\"]"));
                        put("name", By.cssSelector("input[name=\"form_text_98\"]"));
                        put("position", By.cssSelector("input[name=\"form_text_99\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_100\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_101\"]"));
                        put("additionalTelephone", By.cssSelector("input[name=\"form_text_102\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_103\"]"));
                        put("idform", By.className("av-form-parthners"));
                        break;

                case ("https://ru.avmg.com.ua/career/menedzher-po-prodazham+lvov/"):
                        put("mail", By.cssSelector("input[name=\"form_email_104\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_106\"]"));
                        put("idform", By.className("av-form-career"));
                        put("file", By.cssSelector("input[type=\"file\"]"));
                        put("link", By.cssSelector("input[name=\"form_url_214\"]"));
                        put("fileName", By.cssSelector("a[title=\"Просмотр файла\"]"));
                        break;

                case ("https://avmg.com.ua/"):
                        put("name", By.cssSelector("input[name=\"form_text_265\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_266\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_267\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_268\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_269\"]"));
                        put("town", By.cssSelector("input[name=\"form_text_270\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_271\"]"));
                        put("idform", By.className("av-form-index"));
                        break;

                case ("https://avmg.com.ua/contacts/"):
                        put("name", By.cssSelector("input[name=\"form_text_265\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_266\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_267\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_268\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_269\"]"));
                        put("town", By.cssSelector("input[name=\"form_text_270\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_271\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://avmg.com.ua/uslugi/gazovaya-rezka-metalla/"):
                        put("name", By.cssSelector("input[name=\"form_text_215\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_216\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_217\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_218\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_219\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_220\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://avmg.com.ua/uslugi/plazmennaya-rezka-metalla/"):
                        put("name", By.cssSelector("input[name=\"form_text_241\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_242\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_243\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_244\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_245\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_246\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://avmg.com.ua/uslugi/rezka-na-lentopilnom-stanke/"):
                        put("name", By.cssSelector("input[name=\"form_text_247\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_248\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_249\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_250\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_251\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_252\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://avmg.com.ua/uslugi/prodolnaya-rezka-metalla/"):
                        put("name", By.cssSelector("input[name=\"form_text_253\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_254\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_255\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_256\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_257\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_258\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://avmg.com.ua/uslugi/gruzoperevozka/"):
                        put("name", By.cssSelector("input[name=\"form_text_259\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_260\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_261\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_262\"]"));
                        put("company", By.cssSelector("input[name=\"form_text_263\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_264\"]"));
                        put("idform", By.className("av-form"));
                        break;

                case ("https://avmg.com.ua/about/partnersavmg/"):
                        put("companyName", By.cssSelector("input[name=\"form_text_221\"]"));
                        put("legalAdress", By.cssSelector("input[name=\"form_text_222\"]"));
                        put("town", By.cssSelector("input[name=\"form_text_223\"]"));
                        put("postalIndex", By.cssSelector("input[name=\"form_text_224\"]"));
                        put("legalStatus", By.cssSelector("input[name=\"226\"]"));
                        put("addressForDeliveryOfDocuments", By.cssSelector("input[name=\"form_text_227\"]"));
                        put("placeOfdelivery", By.cssSelector("input[name=\"form_text_228\"]"));
                        put("postalCodeOfDelivery", By.cssSelector("input[name=\"form_text_229\"]"));
                        put("surname", By.cssSelector("input[name=\"form_text_230\"]"));
                        put("name", By.cssSelector("input[name=\"form_text_231\"]"));
                        put("position", By.cssSelector("input[name=\"form_text_232\"]"));
                        put("mail", By.cssSelector("input[name=\"form_text_233\"]"));
                        put("telephone", By.cssSelector("input[name=\"form_text_234\"]"));
                        put("additionalTelephone", By.cssSelector("input[name=\"form_text_235\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_236\"]"));
                        put("idform", By.className("av-form-parthners"));
                        break;

                    case ("https://avmg.com.ua/career/menedzher-po-prodazham+lvov/"):
                        put("mail", By.cssSelector("input[name=\"form_email_237\"]"));
                        put("message", By.cssSelector("textarea[name=\"form_textarea_239\"]"));
                        put("idform", By.className("av-form-career"));
                        put("file", By.cssSelector("input[type=\"file\"]"));
                        put("link", By.cssSelector("input[name=\"form_url_240\"]"));
                        put("fileName", By.cssSelector("a[title=\"Просмотр файла\"]"));
                        break;

                    default:
                        System.out.println("ERROR");
                        break;
            }
        }};
        return fieldBy;
    }

}
