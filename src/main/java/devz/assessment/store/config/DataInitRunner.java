//package devz.assessment.store.config;
//
//import devz.assessment.store.entity.MerchantStore;
//import devz.assessment.store.repo.MerchantStoreRepo;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.locationtech.jts.geom.Coordinate;
//import org.locationtech.jts.geom.GeometryFactory;
//import org.locationtech.jts.geom.Point;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class DataInitRunner implements CommandLineRunner {
//
//    private final MerchantStoreRepo repository;
//    private final GeometryFactory geometryFactory = new GeometryFactory();
//
//    @Override
//    public void run(String... args) {
//        if (repository.count() > 0) {
//            log.info("Database already contains {} stores. Skipping initialization.", repository.count());
//            return;
//        }
//
//        log.info("Initializing merchant stores data for Myanmar...");
//
//        List<MerchantStore> stores = new ArrayList<>();
//
//        // ====================================================================
//        // YANGON - Downtown Area (Kyauktada, Pabedan, Botahtaung)
//        // ====================================================================
//        stores.add(createStore("Rangoon Tea House", 16.7780, 96.1450,
//                "77-79 Pansodan St, Kyauktada Township, Yangon", "+959250123456", "Food & Beverage"));
//
//        stores.add(createStore("Shan Yoe Yar", 16.7850, 96.1490,
//                "124 Anawrahta Rd, Lanmadaw Township, Yangon", "+959250234567", "Food & Beverage"));
//
//        stores.add(createStore("999 Shan Noodle Shop", 16.7820, 96.1520,
//                "130B Mahabandoola Rd, Botahtaung Township, Yangon", "+959250345678", "Food & Beverage"));
//
//        stores.add(createStore("Gekko", 16.7795, 96.1485,
//                "535 Merchant St, Kyauktada Township, Yangon", "+959250456789", "Food & Beverage"));
//
//        stores.add(createStore("Green Elephant", 16.7760, 96.1470,
//                "5A-1, 51st St, Botahtaung Township, Yangon", "+959250567890", "Food & Beverage"));
//
//        // ====================================================================
//        // YANGON - Downtown Shopping & Retail
//        // ====================================================================
//        stores.add(createStore("Bogyoke Aung San Market", 16.7787, 96.1548,
//                "Bogyoke Aung San Rd, Pabedan Township, Yangon", "+959251111111", "Shopping Mall"));
//
//        stores.add(createStore("City Mart FMI Centre", 16.7810, 96.1435,
//                "380 Bogyoke Aung San Rd, Pabedan Township, Yangon", "+959251222222", "Retail"));
//
//        stores.add(createStore("Ocean Supercentre Downtown", 16.7755, 96.1605,
//                "Corner of Strand Rd & 51st St, Botahtaung Township, Yangon", "+959251333333", "Retail"));
//
//        // ====================================================================
//        // YANGON - Kamayut & Hledan Area
//        // ====================================================================
//        stores.add(createStore("Sharky's Restaurant", 16.8120, 96.1380,
//                "U Htaung Bo Rd, Kamayut Township, Yangon", "+959252111111", "Food & Beverage"));
//
//        stores.add(createStore("Mingalar Coffee Hledan", 16.8145, 96.1420,
//                "Hledan Centre, Kamayut Township, Yangon", "+959252222222", "Food & Beverage"));
//
//        stores.add(createStore("Daw Yee Myanmar Cuisine", 16.8095, 96.1355,
//                "Pyay Rd, Kamayut Township, Yangon", "+959252333333", "Food & Beverage"));
//
//        stores.add(createStore("City Mart Hledan", 16.8167, 96.1410,
//                "Hledan Market, Kamayut Township, Yangon", "+959252444444", "Retail"));
//
//        stores.add(createStore("Junction City", 16.8200, 96.1350,
//                "Corner of Bogyoke Aung San Rd & Anawrahta Rd, Yangon", "+959252555555", "Shopping Mall"));
//
//        // ====================================================================
//        // YANGON - Bahan & Yankin Area (Golden Valley)
//        // ====================================================================
//        stores.add(createStore("Padonmar Restaurant", 16.8245, 96.1580,
//                "105/107 Dhammazedi Rd, Bahan Township, Yangon", "+959253111111", "Food & Beverage"));
//
//        stores.add(createStore("Karaweik Palace Restaurant", 16.7985, 96.1305,
//                "Kandawgyi Lake, Bahan Township, Yangon", "+959253222222", "Food & Beverage"));
//
//        stores.add(createStore("Myanmar Plaza", 16.8089, 96.1544,
//                "Kabar Aye Pagoda Rd, Yankin Township, Yangon", "+959253333333", "Shopping Mall"));
//
//        stores.add(createStore("City Mart Yankin", 16.8150, 96.1565,
//                "Yankin Centre, Yankin Township, Yangon", "+959253444444", "Retail"));
//
//        // ====================================================================
//        // YANGON - Sanchaung Area
//        // ====================================================================
//        stores.add(createStore("Shwe Sa Bwe", 16.7982, 96.1365,
//                "51st St, Sanchaung Township, Yangon", "+959254111111", "Food & Beverage"));
//
//        stores.add(createStore("BBQ King Sanchaung", 16.8015, 96.1320,
//                "Shwegondine Rd, Sanchaung Township, Yangon", "+959254222222", "Food & Beverage"));
//
//        stores.add(createStore("City Mart Sanchaung", 16.7995, 96.1345,
//                "50th St, Sanchaung Township, Yangon", "+959254333333", "Retail"));
//
//        // ====================================================================
//        // YANGON - Mayangone Area
//        // ====================================================================
//        stores.add(createStore("Sein Gay Har", 16.8350, 96.1120,
//                "Pyay Rd, Mayangone Township, Yangon", "+959255111111", "Food & Beverage"));
//
//        stores.add(createStore("KFC Hledan", 16.8180, 96.1398,
//                "Pyay Rd, Kamayut Township, Yangon", "+959255222222", "Food & Beverage"));
//
//        stores.add(createStore("City Mart Mayangone", 16.8285, 96.1155,
//                "Pyay Rd, Mayangone Township, Yangon", "+959255333333", "Retail"));
//
//        // ====================================================================
//        // YANGON - Insein & North Okkalapa
//        // ====================================================================
//        stores.add(createStore("Golden City Mall", 16.8890, 96.0980,
//                "Pyay Rd, Insein Township, Yangon", "+959256111111", "Shopping Mall"));
//
//        stores.add(createStore("Ocean North Point", 16.9125, 96.1565,
//                "Thanlyin-Insein Rd, North Okkalapa Township, Yangon", "+959256222222", "Shopping Mall"));
//
//        // ====================================================================
//        // YANGON - Thaketa & Mingalar Taung Nyunt
//        // ====================================================================
//        stores.add(createStore("Capital Diamond Star City", 16.8525, 96.1985,
//                "Thanlyin-Insein Rd, Thaketa Township, Yangon", "+959257111111", "Shopping Mall"));
//
//        stores.add(createStore("City Mart Thaketa", 16.8445, 96.1920,
//                "Wai Bar Gi Rd, Thaketa Township, Yangon", "+959257222222", "Retail"));
//
//        // ====================================================================
//        // MANDALAY - Downtown Area
//        // ====================================================================
//        stores.add(createStore("Shan Ma Ma Restaurant", 21.9588, 96.0891,
//                "66th St, Between 26th & 27th St, Chan Aye Thar Zan, Mandalay", "+959261111111", "Food & Beverage"));
//
//        stores.add(createStore("Mingalar Thiri Restaurant", 21.9670, 96.0850,
//                "27th St, Between 73rd & 74th St, Chan Aye Thar Zan, Mandalay", "+959261222222", "Food & Beverage"));
//
//        stores.add(createStore("Lashio Lay", 21.9750, 96.0920,
//                "35th St, Between 82nd & 83rd St, Chan Aye Thar Zan, Mandalay", "+959261333333", "Food & Beverage"));
//
//        stores.add(createStore("Too Too Myanmar Restaurant", 21.9625, 96.0785,
//                "83rd St, Between 26th & 27th St, Aung Myay Thar Zan, Mandalay", "+959261444444", "Food & Beverage"));
//
//        // ====================================================================
//        // MANDALAY - Shopping & Retail
//        // ====================================================================
//        stores.add(createStore("Diamond Plaza Mandalay", 21.9715, 96.0895,
//                "Corner of 80th St & 35th St, Chan Aye Thar Zan, Mandalay", "+959262111111", "Shopping Mall"));
//
//        stores.add(createStore("City Mart Mandalay", 21.9680, 96.0865,
//                "80th St, Between 30th & 31st St, Mandalay", "+959262222222", "Retail"));
//
//        stores.add(createStore("Capital Hypermarket Mandalay", 21.9750, 96.0850,
//                "35th St, Between 80th & 81st St, Chan Aye Thar Zan, Mandalay", "+959262333333", "Retail"));
//
//        stores.add(createStore("Shwe Pyi Thar Mandalay", 21.9560, 96.0820,
//                "78th St, Between 32nd & 33rd St, Mandalay", "+959262444444", "Shopping Mall"));
//
//        // ====================================================================
//        // MANDALAY - Near Royal Palace & Attractions
//        // ====================================================================
//        stores.add(createStore("Royal Palace Restaurant", 21.9833, 96.0833,
//                "Near Mandalay Palace, 12th St, Mandalay", "+959263111111", "Food & Beverage"));
//
//        stores.add(createStore("Mandalay Hill Coffee Shop", 22.0180, 96.0945,
//                "Mandalay Hill Rd, Chan Aye Thar Zan, Mandalay", "+959263222222", "Food & Beverage"));
//
//        // ====================================================================
//        // NAY PYI TAW - Capital City
//        // ====================================================================
//        stores.add(createStore("Junction Centre Nay Pyi Taw", 19.7475, 96.1150,
//                "Yazathingaha Rd, Ottarathiri Township, Nay Pyi Taw", "+959271111111", "Shopping Mall"));
//
//        stores.add(createStore("Capital Hypermarket NPT", 19.7635, 96.0990,
//                "Thapyaygone Rd, Dekkhina Thiri Township, Nay Pyi Taw", "+959271222222", "Retail"));
//
//        stores.add(createStore("Golden Myanmar Restaurant NPT", 19.7520, 96.1085,
//                "Yazathingaha Rd, Ottarathiri Township, Nay Pyi Taw", "+959271333333", "Food & Beverage"));
//
//        // ====================================================================
//        // BAGO (Previously Pegu)
//        // ====================================================================
//        stores.add(createStore("Shwe Maw Daw Restaurant", 17.3355, 96.4805,
//                "Near Shwemawdaw Pagoda, Bago", "+959281111111", "Food & Beverage"));
//
//        stores.add(createStore("Hanthawaddy Shopping Centre", 17.3315, 96.4835,
//                "Yangon-Mandalay Rd, Bago", "+959281222222", "Shopping Mall"));
//
//        // ====================================================================
//        // MAWLAMYINE (Mon State)
//        // ====================================================================
//        stores.add(createStore("Kyaikthanian Pagoda View Restaurant", 16.4905, 97.6285,
//                "Strand Rd, Mawlamyine, Mon State", "+959291111111", "Food & Beverage"));
//
//        stores.add(createStore("City Mart Mawlamyine", 16.4850, 97.6245,
//                "Bogyoke Rd, Mawlamyine, Mon State", "+959291222222", "Retail"));
//
//        // ====================================================================
//        // TAUNGGYI (Shan State Capital)
//        // ====================================================================
//        stores.add(createStore("Shwe Shan Restaurant", 20.7845, 97.0385,
//                "Bogyoke Rd, Taunggyi, Shan State", "+959301111111", "Food & Beverage"));
//
//        stores.add(createStore("Taunggyi Market", 20.7895, 97.0425,
//                "Main Market Rd, Taunggyi, Shan State", "+959301222222", "Retail"));
//
//        // ====================================================================
//        // PATHEIN (Ayeyarwady Region)
//        // ====================================================================
//        stores.add(createStore("Pathein Halawa Restaurant", 16.7785, 94.7330,
//                "Merchant St, Pathein, Ayeyarwady Region", "+959311111111", "Food & Beverage"));
//
//        stores.add(createStore("Shwe Pyi Thar Pathein", 16.7825, 94.7365,
//                "Bogyoke Rd, Pathein, Ayeyarwady Region", "+959311222222", "Shopping Mall"));
//
//        // ====================================================================
//        // Additional Yangon Cafes & Modern Spots
//        // ====================================================================
//        stores.add(createStore("Café Navarre", 16.7812, 96.1502,
//                "Sule Pagoda Rd, Kyauktada Township, Yangon", "+959258111111", "Food & Beverage"));
//
//        stores.add(createStore("Seeds Restaurant", 16.8198, 96.1435,
//                "Kaba Aye Pagoda Rd, Bahan Township, Yangon", "+959258222222", "Food & Beverage"));
//
//        stores.add(createStore("Monsoon Restaurant", 16.8055, 96.1615,
//                "85-87 Thein Phyu Rd, Botahtaung Township, Yangon", "+959258333333", "Food & Beverage"));
//
//        stores.add(createStore("The Strand Café", 16.7765, 96.1595,
//                "92 Strand Rd, Kyauktada Township, Yangon", "+959258444444", "Food & Beverage"));
//
//        stores.add(createStore("Books Paradise", 16.7885, 96.1455,
//                "100-102, 37th St, Kyauktada Township, Yangon", "+959258555555", "Retail"));
//
//        stores.add(createStore("Pharmacy First Care", 16.8125, 96.1450,
//                "Pyay Rd, Kamayut Township, Yangon", "+959258666666", "Health & Wellness"));
//
//        stores.add(createStore("Fitness Studio Yangon", 16.8100, 96.1520,
//                "Junction Maw Tin, Hledan, Yangon", "+959258777777", "Health & Fitness"));
//
//        stores.add(createStore("Celltech Mobile Shop", 16.7845, 96.1480,
//                "Bogyoke Aung San Market, Yangon", "+959258888888", "Electronics"));
//
//        stores.add(createStore("FMI Electronics Centre", 16.8300, 96.1400,
//                "380 Bogyoke Aung San Rd, Pabedan Township, Yangon", "+959258999999", "Electronics"));
//
//        // Save all stores
//        repository.saveAll(stores);
//
//        log.info("Successfully initialized {} merchant stores across Myanmar", stores.size());
//        log.info("Cities covered: Yangon, Mandalay, Nay Pyi Taw, Bago, Mawlamyine, Taunggyi, Pathein");
//    }
//
//    private MerchantStore createStore(String name, Double lat, Double lon,
//                                      String address, String phone, String category) {
//        Point location = geometryFactory.createPoint(new Coordinate(lon, lat));
//
//        return MerchantStore.builder()
//                .storeName(name)
//                .location(location)
//                .address(address)
//                .phoneNumber(phone)
//                .category(category)
//                .isActive(true)
//                .build();
//    }
//}