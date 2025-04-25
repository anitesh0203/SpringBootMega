//package practice;
//
//import java.util.Collection;
//import java.util.Optional;
//
//public class ScratchPad {
//    public static void main(String[] args) {
//        Species species = new Species();
//        Man man = new Man();
//        man.id = 121;
//
//
//        Optional<String> id = Optional.of(species)
//                .map(Species::getMan)
//                .map(Man::getName);
//
//        System.out.println(id);
//
//
//        Man testMan = new Man();
//        testMan.setId(12);
//        testMan.setName("Anitesh");
//        testMan.setRules(null);
//
//        Optional.ofNullable(testMan).map(Man::getRules).map(rules -> StringUtils.join(rules, ",")).orElse("");
//
//
////        Collection<String> list = new ArrayList<>();
////        list.add("hello");
////        list.add(null);
////        System.out.println(list.size());
////        for (String item : list) {
////            System.out.println(item.toLowerCase());
////        }
//    }
//
//    private static String join(Collection collection, String seperator) {
//        if(collection == null) {
//            return null;
//        }
//        return join(collection.iterator(), seperator);
//    }
//}
