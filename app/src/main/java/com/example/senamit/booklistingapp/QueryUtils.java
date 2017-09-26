package com.example.senamit.booklistingapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by senamit on 26/9/17.
 */

public class QueryUtils {


    public static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }


    public static final String SAMPLE_JSON_RESPONSE = "{\n" +
            " \"kind\": \"books#volumes\",\n" +
            " \"totalItems\": 3044,\n" +
            " \"items\": [\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"zDibrpXTfxMC\",\n" +
            "   \"etag\": \"9p7p1JDXWUI\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/zDibrpXTfxMC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android Forensics\",\n" +
            "    \"subtitle\": \"Investigation, Analysis, and Mobile Security for Google Android\",\n" +
            "    \"authors\": [\n" +
            "     \"Andrew Hoog\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Elsevier\",\n" +
            "    \"publishedDate\": \"2011\",\n" +
            "    \"description\": \"The open source nature of the platform has not only established a new direction for the industry, but enables a developer or forensic analyst to understand the device at the most fundamental level. Android Forensics covers an open source mobile device platform based on the Linux 2.6 kernel and managed by the Open Handset Alliance. The Android platform is a major source of digital forensic investigation and analysis. This book provides a thorough review of the Android platform including supported hardware devices, the structure of the Android development project and implementation of core services (wireless communication, data storage and other low-level functions). Finally, it will focus on teaching readers how to apply actual forensic techniques to recover data. Ability to forensically acquire Android devices using the techniques outlined in the book Detailed information about Android applications needed for forensics investigations Important information about SQLite, a file based structured data storage relevant for both Android and many other platforms.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781597496513\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1597496510\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 372,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=zDibrpXTfxMC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=zDibrpXTfxMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=zDibrpXTfxMC&printsec=frontcover&dq=android&hl=&cd=1&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=zDibrpXTfxMC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Forensics.html?hl=&id=zDibrpXTfxMC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=zDibrpXTfxMC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"This book provides a thorough review of the Android platform including supported hardware devices, the structure of the Android development project and implementation of core services (wireless communication, data storage and other low ...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"V-gtAgAAQBAJ\",\n" +
            "   \"etag\": \"GH6yNp4CvIY\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/V-gtAgAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Voice Application Development for Android\",\n" +
            "    \"authors\": [\n" +
            "     \"Michael F. McTear\",\n" +
            "     \"Zoraida Callejas\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Packt Publishing Ltd\",\n" +
            "    \"publishedDate\": \"2013-12-11\",\n" +
            "    \"description\": \"This book will give beginners an introduction to building voice-based applications on Android. It will begin by covering the basic concepts and will build up to creating a voice-based personal assistant. By the end of this book, you should be in a position to create your own voice-based applications on Android from scratch in next to no time.Voice Application Development for Android is for all those who are interested in speech technology and for those who, as owners of Android devices, are keen to experiment with developing voice apps for their devices. It will also be useful as a starting point for professionals who are experienced in Android application development but who are not familiar with speech technologies and the development of voice user interfaces. Some background in programming in general, particularly in Java, is assumed.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781783285303\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1783285303\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 134,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"1.3.4.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=V-gtAgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=V-gtAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=V-gtAgAAQBAJ&printsec=frontcover&dq=android&hl=&cd=2&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=V-gtAgAAQBAJ&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-V-gtAgAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 1401.83,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 700.92,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=V-gtAgAAQBAJ&rdid=book-V-gtAgAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 1.40183E9,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 7.0092E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=V-gtAgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"This book will give beginners an introduction to building voice-based applications on Android.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"MoXpe6H2B5gC\",\n" +
            "   \"etag\": \"BcUjYr2pNls\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/MoXpe6H2B5gC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android in The Attic\",\n" +
            "    \"authors\": [\n" +
            "     \"Nicholas Allan\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Hachette UK\",\n" +
            "    \"publishedDate\": \"2013-01-03\",\n" +
            "    \"description\": \"Aunt Edna has created a no-nonsense nanny android to make sure Billy and Alfie don't have any fun. But then Alfie discovers how to override Auntie Anne-Droid's programming and nothing can stop them eating all the Cheeki Choko Cherry Cakes they like ... until the real aunt Edna is kidnapped!\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781444905465\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1444905465\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": false\n" +
            "    },\n" +
            "    \"pageCount\": 192,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Juvenile Fiction\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"1.2.2.0.preview.2\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=MoXpe6H2B5gC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=MoXpe6H2B5gC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=MoXpe6H2B5gC&printsec=frontcover&dq=android&hl=&cd=3&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=MoXpe6H2B5gC&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-MoXpe6H2B5gC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 250.16,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 175.11,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=MoXpe6H2B5gC&rdid=book-MoXpe6H2B5gC&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 2.5016E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 1.7511E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Android_in_The_Attic-sample-epub.acsm?id=MoXpe6H2B5gC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=MoXpe6H2B5gC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Aunt Edna has created a no-nonsense nanny android to make sure Billy and Alfie don&#39;t have any fun.\"\n" +
            "   }\n" +
            "  }\n" +
            " ]\n" +
            "}";


    //A value in the JSON may be optional, so using optJSONObject is better because you just have to check if it is null or not and continue your function.
    public static ArrayList<Books> extractFeatureFromJSON() throws JSONException {

        ArrayList<Books> books= new ArrayList<Books>();
        String author=null;
        String title=null;

        JSONObject baseJsonObject =new  JSONObject(SAMPLE_JSON_RESPONSE);
        JSONArray jsonItemsArray = baseJsonObject.optJSONArray("items");

        for (int i=0; i<jsonItemsArray.length(); i++){

            JSONObject jsonItemObject = jsonItemsArray.optJSONObject(i);

            JSONObject jsonVolumeInfo = jsonItemObject.optJSONObject("volumeInfo");

            JSONArray jsonAuthor = jsonVolumeInfo.optJSONArray("authors");

            title = jsonVolumeInfo.optString("title");
//            for (int j=0; j<jsonAuthor.length(); j++)
//            {
//                 author = jsonAuthor.optString(i);
//
//
//            }
            author = jsonAuthor.optString(0);

//            String author ="amit sen";

            books.add(new Books(title, author));
        }





        return books;
    }

}


