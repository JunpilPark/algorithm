public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap(key -> {
            return (long) Math.abs(key.hashCode()) * 11;
        });

        hashMap.put("junpil", "park");
        hashMap.put("sangtak", "park2");

        System.out.println(hashMap.get("junpi"));
        System.out.println(hashMap.get("sangtak"));

        hashMap.removeAll();

        System.out.println(hashMap.get("junpi"));
        System.out.println(hashMap.getSize());

    }
}
