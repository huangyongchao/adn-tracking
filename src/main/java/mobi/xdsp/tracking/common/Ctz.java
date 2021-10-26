package mobi.xdsp.tracking.common;

import com.google.common.collect.Maps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
 * country  timezone
 */
public class Ctz {

    private final static Map<String, String> COUNTRY_TIMEZONE = Maps.newHashMap();

    static {
        COUNTRY_TIMEZONE.put("ARE", "+04:00");
        COUNTRY_TIMEZONE.put("ARG", "-03:00");
        COUNTRY_TIMEZONE.put("AUT", "+01:00");
        COUNTRY_TIMEZONE.put("AUS", "+09:00");
        COUNTRY_TIMEZONE.put("BGD", "+06:00");
        COUNTRY_TIMEZONE.put("BHR", "+03:00");
        COUNTRY_TIMEZONE.put("BRA", "+00:00");
        COUNTRY_TIMEZONE.put("BLR", "+02:00");
        COUNTRY_TIMEZONE.put("CAN", "-03:00");
        COUNTRY_TIMEZONE.put("CHL", "-04:00");
        COUNTRY_TIMEZONE.put("COL", "+00:00");
        COUNTRY_TIMEZONE.put("CZE", "+01:00");
        COUNTRY_TIMEZONE.put("DEU", "+01:00");
        COUNTRY_TIMEZONE.put("EGY", "+02:00");
        COUNTRY_TIMEZONE.put("ESP", "+01:00");
        COUNTRY_TIMEZONE.put("FRA", "+01:00");
        COUNTRY_TIMEZONE.put("HKG", "+08:00");
        COUNTRY_TIMEZONE.put("IDN", "+08:00");
        COUNTRY_TIMEZONE.put("IND", "+05:00");
        COUNTRY_TIMEZONE.put("IRQ", "+03:00");
        COUNTRY_TIMEZONE.put("IRN", "+04:00");
        COUNTRY_TIMEZONE.put("ITA", "+01:00");
        COUNTRY_TIMEZONE.put("JPN", "+09:00");
        COUNTRY_TIMEZONE.put("KWT", "+03:00");
        COUNTRY_TIMEZONE.put("LBN", "+02:00");
        COUNTRY_TIMEZONE.put("MAR", "+00:00");
        COUNTRY_TIMEZONE.put("MEX", "-07:00");
        COUNTRY_TIMEZONE.put("MYS", "+08:00");
        COUNTRY_TIMEZONE.put("NGA", "+01:00");
        COUNTRY_TIMEZONE.put("NLD", "+01:00");
        COUNTRY_TIMEZONE.put("OMN", "+04:00");
        COUNTRY_TIMEZONE.put("PER", "-04:00");
        COUNTRY_TIMEZONE.put("PHL", "+08:00");
        COUNTRY_TIMEZONE.put("PAK", "+05:00");
        COUNTRY_TIMEZONE.put("POL", "+01:00");
        COUNTRY_TIMEZONE.put("QAT", "+03:00");
        COUNTRY_TIMEZONE.put("RUS", "+03:00");
        COUNTRY_TIMEZONE.put("SGP", "+08:00");
        COUNTRY_TIMEZONE.put("SVK", "+01:00");
        COUNTRY_TIMEZONE.put("THA", "+07:00");
        COUNTRY_TIMEZONE.put("TUR", "+03:00");
        COUNTRY_TIMEZONE.put("TZA", "+03:00");
        COUNTRY_TIMEZONE.put("USA", "-04:00");
        COUNTRY_TIMEZONE.put("VNM", "+07:00");
        COUNTRY_TIMEZONE.put("CHN", "+08:00");
        COUNTRY_TIMEZONE.put("ETH", "+03:00");
        COUNTRY_TIMEZONE.put("GBR", "+00:00");
        COUNTRY_TIMEZONE.put("TWN", "+08:00");
        COUNTRY_TIMEZONE.put("SAU", "+03:00");
        COUNTRY_TIMEZONE.put("KOR", "+09:00");
        COUNTRY_TIMEZONE.put("PRT", "+00:00");
        COUNTRY_TIMEZONE.put("KEN", "+03:00");
        COUNTRY_TIMEZONE.put("GBR", "+00:00");
    }

    public static ZoneId of(String country) {
        if (COUNTRY_TIMEZONE.containsKey(country.toUpperCase())) {
            return ZoneId.of(COUNTRY_TIMEZONE.get(country.toUpperCase()));
        }

        return ZoneId.of("+00:00");
    }

    public static Date utcToLocal(String utcTime, String geo3, Date utcDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));


        try {
            if (utcDate == null) {

                utcDate = sdf.parse(utcTime);
            }

        } catch (ParseException e) {
            e.printStackTrace();

        }

        sdf.setTimeZone(TimeZone.getTimeZone(Ctz.of(geo3)));

        Date locatlDate = null;

        String localTime = sdf.format(utcDate.getTime());

        locatlDate = DateTimeUtil.strToDateLong(localTime);


        return locatlDate;

    }


    public static int utcToLocalHour(int utcHour, String geo3) {


        String utcStr = DateTimeUtil.getStringDateShort() +" "+ utcHour + ":00:00";
        Date utcDate = DateTimeUtil.strToDateLong(utcStr);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        sdf.setTimeZone(TimeZone.getTimeZone(geo3));

        Date locatlDate = null;
        try {
            locatlDate = sdf.parse(DateTimeUtil.dateToStrLong(utcDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return locatlDate.getHours();

    }

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(utcToLocal("", "RUS", new Date()));
        System.out.println(utcToLocalHour(0, "Asia/Shanghai"));
    }

/*
    其中可的用所有ID.
            Etc/GMT+12
    Etc/GMT+11
    MIT
    Pacific/Apia
    Pacific/Midway
    Pacific/Niue
    Pacific/Pago_Pago
    Pacific/Samoa
    US/Samoa
    America/Adak
    America/Atka
    Etc/GMT+10
    HST
    Pacific/Fakaofo
    Pacific/Honolulu
    Pacific/Johnston
    Pacific/Rarotonga
    Pacific/Tahiti
    SystemV/HST10
    US/Aleutian
    US/Hawaii
    Pacific/Marquesas
            AST
    America/Anchorage
    America/Juneau
    America/Nome
    America/Yakutat
    Etc/GMT+9
    Pacific/Gambier
    SystemV/YST9
    SystemV/YST9YDT
    US/Alaska
    America/Dawson
    America/Ensenada
    America/Los_Angeles
    America/Tijuana
    America/Vancouver
    America/Whitehorse
    Canada/Pacific
    Canada/Yukon
    Etc/GMT+8
    Mexico/BajaNorte
            PST
    PST8PDT
    Pacific/Pitcairn
    SystemV/PST8
    SystemV/PST8PDT
    US/Pacific
    US/Pacific-New
    America/Boise
    America/Cambridge_Bay
    America/Chihuahua
    America/Dawson_Creek
    America/Denver
    America/Edmonton
    America/Hermosillo
    America/Inuvik
    America/Mazatlan
    America/Phoenix
    America/Shiprock
    America/Yellowknife
    Canada/Mountain
    Etc/GMT+7
    MST
            MST7MDT
    Mexico/BajaSur
            Navajo
    PNT
    SystemV/MST7
    SystemV/MST7MDT
    US/Arizona
    US/Mountain
    America/Belize
    America/Cancun
    America/Chicago
    America/Costa_Rica
    America/El_Salvador
    America/Guatemala
    America/Indiana/Knox
    America/Indiana/Tell_City
    America/Knox_IN
    America/Managua
    America/Menominee
    America/Merida
    America/Mexico_City
    America/Monterrey
    America/North_Dakota/Center
    America/North_Dakota/New_Salem
    America/Rainy_River
    America/Rankin_Inlet
    America/Regina
    America/Swift_Current
    America/Tegucigalpa
    America/Winnipeg
            CST
    CST6CDT
    Canada/Central
    Canada/East-Saskatchewan
    Canada/Saskatchewan
    Chile/EasterIsland
    Etc/GMT+6
    Mexico/General
    Pacific/Easter
    Pacific/Galapagos
    SystemV/CST6
    SystemV/CST6CDT
    US/Central
    US/Indiana-Starke
    America/Atikokan
    America/Bogota
    America/Cayman
    America/Coral_Harbour
    America/Detroit
    America/Fort_Wayne
    America/Grand_Turk
    America/Guayaquil
    America/Havana
    America/Indiana/Indianapolis
    America/Indiana/Marengo
    America/Indiana/Petersburg
    America/Indiana/Vevay
    America/Indiana/Vincennes
    America/Indiana/Winamac
    America/Indianapolis
    America/Iqaluit
    America/Jamaica
    America/Kentucky/Louisville
    America/Kentucky/Monticello
    America/Lima
    America/Louisville
    America/Montreal
    America/Nassau
    America/New_York
    America/Nipigon
    America/Panama
    America/Pangnirtung
    America/Port-au-Prince
    America/Resolute
    America/Thunder_Bay
    America/Toronto
    Canada/Eastern
            Cuba
    EST
            EST5EDT
    Etc/GMT+5
    IET
            Jamaica
    SystemV/EST5
    SystemV/EST5EDT
    US/East-Indiana
    US/Eastern
    US/Michigan
    America/Caracas
    America/Anguilla
    America/Antigua
    America/Aruba
    America/Asuncion
    America/Barbados
    America/Blanc-Sablon
    America/Boa_Vista
    America/Campo_Grande
    America/Cuiaba
    America/Curacao
    America/Dominica
    America/Eirunepe
    America/Glace_Bay
    America/Goose_Bay
    America/Grenada
    America/Guadeloupe
    America/Guyana
    America/Halifax
    America/La_Paz
    America/Manaus
    America/Marigot
    America/Martinique
    America/Moncton
    America/Montserrat
    America/Port_of_Spain
    America/Porto_Acre
    America/Porto_Velho
    America/Puerto_Rico
    America/Rio_Branco
    America/Santiago
    America/Santo_Domingo
    America/St_Barthelemy
    America/St_Kitts
    America/St_Lucia
    America/St_Thomas
    America/St_Vincent
    America/Thule
    America/Tortola
    America/Virgin
    Antarctica/Palmer
    Atlantic/Bermuda
    Atlantic/Stanley
    Brazil/Acre
    Brazil/West
    Canada/Atlantic
    Chile/Continental
    Etc/GMT+4
    PRT
    SystemV/AST4
    SystemV/AST4ADT
    America/St_Johns
            CNT
    Canada/Newfoundland
            AGT
    America/Araguaina
    America/Argentina/Buenos_Aires
    America/Argentina/Catamarca
    America/Argentina/ComodRivadavia
    America/Argentina/Cordoba
    America/Argentina/Jujuy
    America/Argentina/La_Rioja
    America/Argentina/Mendoza
    America/Argentina/Rio_Gallegos
    America/Argentina/Salta
    America/Argentina/San_Juan
    America/Argentina/San_Luis
    America/Argentina/Tucuman
    America/Argentina/Ushuaia
    America/Bahia
    America/Belem
    America/Buenos_Aires
    America/Catamarca
    America/Cayenne
    America/Cordoba
    America/Fortaleza
    America/Godthab
    America/Jujuy
    America/Maceio
    America/Mendoza
    America/Miquelon
    America/Montevideo
    America/Paramaribo
    America/Recife
    America/Rosario
    America/Santarem
    America/Sao_Paulo
    Antarctica/Rothera
            BET
    Brazil/East
    Etc/GMT+3
    America/Noronha
    Atlantic/South_Georgia
    Brazil/DeNoronha
    Etc/GMT+2
    America/Scoresbysund
    Atlantic/Azores
    Atlantic/Cape_Verde
    Etc/GMT+1
    Africa/Abidjan
    Africa/Accra
    Africa/Bamako
    Africa/Banjul
    Africa/Bissau
    Africa/Casablanca
    Africa/Conakry
    Africa/Dakar
    Africa/El_Aaiun
    Africa/Freetown
    Africa/Lome
    Africa/Monrovia
    Africa/Nouakchott
    Africa/Ouagadougou
    Africa/Sao_Tome
    Africa/Timbuktu
    America/Danmarkshavn
    Atlantic/Canary
    Atlantic/Faeroe
    Atlantic/Faroe
    Atlantic/Madeira
    Atlantic/Reykjavik
    Atlantic/St_Helena
            Eire
    Etc/GMT
    Etc/GMT+0
    Etc/GMT-0
    Etc/GMT0
    Etc/Greenwich
    Etc/UCT
    Etc/UTC
    Etc/Universal
    Etc/Zulu
    Europe/Belfast
    Europe/Dublin
    Europe/Guernsey
    Europe/Isle_of_Man
    Europe/Jersey
    Europe/Lisbon
    Europe/London
            GB
    GB-Eire
            GMT
    GMT0
            Greenwich
    Iceland
            Portugal
    UCT
            UTC
    Universal
            WET
    Zulu
    Africa/Algiers
    Africa/Bangui
    Africa/Brazzaville
    Africa/Ceuta
    Africa/Douala
    Africa/Kinshasa
    Africa/Lagos
    Africa/Libreville
    Africa/Luanda
    Africa/Malabo
    Africa/Ndjamena
    Africa/Niamey
    Africa/Porto-Novo
    Africa/Tunis
    Africa/Windhoek
    Arctic/Longyearbyen
    Atlantic/Jan_Mayen
            CET
    ECT
    Etc/GMT-1
    Europe/Amsterdam
    Europe/Andorra
    Europe/Belgrade
    Europe/Berlin
    Europe/Bratislava
    Europe/Brussels
    Europe/Budapest
    Europe/Copenhagen
    Europe/Gibraltar
    Europe/Ljubljana
    Europe/Luxembourg
    Europe/Madrid
    Europe/Malta
    Europe/Monaco
    Europe/Oslo
    Europe/Paris
    Europe/Podgorica
    Europe/Prague
    Europe/Rome
    Europe/San_Marino
    Europe/Sarajevo
    Europe/Skopje
    Europe/Stockholm
    Europe/Tirane
    Europe/Vaduz
    Europe/Vatican
    Europe/Vienna
    Europe/Warsaw
    Europe/Zagreb
    Europe/Zurich
            MET
    Poland
            ART
    Africa/Blantyre
    Africa/Bujumbura
    Africa/Cairo
    Africa/Gaborone
    Africa/Harare
    Africa/Johannesburg
    Africa/Kigali
    Africa/Lubumbashi
    Africa/Lusaka
    Africa/Maputo
    Africa/Maseru
    Africa/Mbabane
    Africa/Tripoli
    Asia/Amman
    Asia/Beirut
    Asia/Damascus
    Asia/Gaza
    Asia/Istanbul
    Asia/Jerusalem
    Asia/Nicosia
    Asia/Tel_Aviv
            CAT
    EET
            Egypt
    Etc/GMT-2
    Europe/Athens
    Europe/Bucharest
    Europe/Chisinau
    Europe/Helsinki
    Europe/Istanbul
    Europe/Kaliningrad
    Europe/Kiev
    Europe/Mariehamn
    Europe/Minsk
    Europe/Nicosia
    Europe/Riga
    Europe/Simferopol
    Europe/Sofia
    Europe/Tallinn
    Europe/Tiraspol
    Europe/Uzhgorod
    Europe/Vilnius
    Europe/Zaporozhye
            Israel
    Libya
            Turkey
    Africa/Addis_Ababa
    Africa/Asmara
    Africa/Asmera
    Africa/Dar_es_Salaam
    Africa/Djibouti
    Africa/Kampala
    Africa/Khartoum
    Africa/Mogadishu
    Africa/Nairobi
    Antarctica/Syowa
    Asia/Aden
    Asia/Baghdad
    Asia/Bahrain
    Asia/Kuwait
    Asia/Qatar
    Asia/Riyadh
            EAT
    Etc/GMT-3
    Europe/Moscow
    Europe/Volgograd
    Indian/Antananarivo
    Indian/Comoro
    Indian/Mayotte
    W-SU
    Asia/Riyadh87
    Asia/Riyadh88
    Asia/Riyadh89
    Mideast/Riyadh87
    Mideast/Riyadh88
    Mideast/Riyadh89
    Asia/Tehran
            Iran
    Asia/Baku
    Asia/Dubai
    Asia/Muscat
    Asia/Tbilisi
    Asia/Yerevan
    Etc/GMT-4
    Europe/Samara
    Indian/Mahe
    Indian/Mauritius
    Indian/Reunion
            NET
    Asia/Kabul
    Asia/Aqtau
    Asia/Aqtobe
    Asia/Ashgabat
    Asia/Ashkhabad
    Asia/Dushanbe
    Asia/Karachi
    Asia/Oral
    Asia/Samarkand
    Asia/Tashkent
    Asia/Yekaterinburg
    Etc/GMT-5
    Indian/Kerguelen
    Indian/Maldives
            PLT
    Asia/Calcutta
    Asia/Colombo
    Asia/Kolkata
            IST
    Asia/Kathmandu
    Asia/Katmandu
    Antarctica/Mawson
    Antarctica/Vostok
    Asia/Almaty
    Asia/Bishkek
    Asia/Dacca
    Asia/Dhaka
    Asia/Novosibirsk
    Asia/Omsk
    Asia/Qyzylorda
    Asia/Thimbu
    Asia/Thimphu
            BST
    Etc/GMT-6
    Indian/Chagos
    Asia/Rangoon
    Indian/Cocos
    Antarctica/Davis
    Asia/Bangkok
    Asia/Ho_Chi_Minh
    Asia/Hovd
    Asia/Jakarta
    Asia/Krasnoyarsk
    Asia/Phnom_Penh
    Asia/Pontianak
    Asia/Saigon
    Asia/Vientiane
    Etc/GMT-7
    Indian/Christmas
            VST
    Antarctica/Casey
    Asia/Brunei
    Asia/Choibalsan
    Asia/Chongqing
    Asia/Chungking
    Asia/Harbin
    Asia/Hong_Kong
    Asia/Irkutsk
    Asia/Kashgar
    Asia/Kuala_Lumpur
    Asia/Kuching
    Asia/Macao
    Asia/Macau
    Asia/Makassar
    Asia/Manila
    Asia/Shanghai
    Asia/Singapore
    Asia/Taipei
    Asia/Ujung_Pandang
    Asia/Ulaanbaatar
    Asia/Ulan_Bator
    Asia/Urumqi
    Australia/Perth
    Australia/West
            CTT
    Etc/GMT-8
    Hongkong
            PRC
    Singapore
    Australia/Eucla
    Asia/Dili
    Asia/Jayapura
    Asia/Pyongyang
    Asia/Seoul
    Asia/Tokyo
    Asia/Yakutsk
    Etc/GMT-9
    JST
            Japan
    Pacific/Palau
            ROK
    ACT
    Australia/Adelaide
    Australia/Broken_Hill
    Australia/Darwin
    Australia/North
    Australia/South
    Australia/Yancowinna
            AET
    Antarctica/DumontDUrville
    Asia/Sakhalin
    Asia/Vladivostok
    Australia/ACT
    Australia/Brisbane
    Australia/Canberra
    Australia/Currie
    Australia/Hobart
    Australia/Lindeman
    Australia/Melbourne
    Australia/NSW
    Australia/Queensland
    Australia/Sydney
    Australia/Tasmania
    Australia/Victoria
    Etc/GMT-10
    Pacific/Guam
    Pacific/Port_Moresby
    Pacific/Saipan
    Pacific/Truk
    Pacific/Yap
    Australia/LHI
    Australia/Lord_Howe
    Asia/Magadan
    Etc/GMT-11
    Pacific/Efate
    Pacific/Guadalcanal
    Pacific/Kosrae
    Pacific/Noumea
    Pacific/Ponape
            SST
    Pacific/Norfolk
    Antarctica/McMurdo
    Antarctica/South_Pole
    Asia/Anadyr
    Asia/Kamchatka
    Etc/GMT-12
    Kwajalein
            NST
    NZ
    Pacific/Auckland
    Pacific/Fiji
    Pacific/Funafuti
    Pacific/Kwajalein
    Pacific/Majuro
    Pacific/Nauru
    Pacific/Tarawa
    Pacific/Wake
    Pacific/Wallis
    NZ-CHAT
    Pacific/Chatham
    Etc/GMT-13
    Pacific/Enderbury
    Pacific/Tongatapu
    Etc/GMT-14
    Pacific/Kiritimati*/

}
