package Main;

public class Gorilla {

     //Main.Gorilla Name. Must contain 1 character
    private String name;
    private char gender;
    private int month;
    private int year;
    private Gorilla mom;
    private Gorilla pop;
    private int children;

    /**
     * Constructor: a new Main.Gorilla with name n, birth year y, birth month m, and gender g.<br>
     * Its father and mother are unknown, and it has no children.<br>
     * Precondition: n has at least one character in it, m is 1 for Jan, 2 for Feb, etc., and<br>
     * g is 'f' or 'm' for female or male
     */
    public Gorilla(String n, int y, int m, char g){
        //Preconditions:
        assert n!=null && n.length() >= 1;
        assert m >= 1 && m <=12;
        assert g == 'f' || g == 'm';
        name = n;
        year = y;
        month = m;
        mom = null;
        pop = null;
        children = 0;
        gender = g;
    }
    //getter methods--
    public String name(){
        return name;
    }
    public boolean isFemale(){
        return gender == 'f';
    }
    public int month(){
        return month;
    }
    public int year(){
        return year;
    }
    public Gorilla mom(){
        return mom;
    }
    public Gorilla pop(){
        return pop;
    }
    public int numChildren(){
        return children;
    }

    //setter methods --
    /**
     * Set the gorilla's mom to mother.<br>
     * Precondition: this gorilla's mom is null, mother is not null, and<br>
     * mother is female.
     * @return
     */
    public void setMom(Gorilla mother){
        assert mother != null;
        assert mother.isFemale();
        assert mom == null;
        mom = mother;
        mom.children++;
    }

    /**
     * Set this gorilla's dad to father.<br>
     * Precondition: this gorilla's dad is null, father is not null, and<br> father is male.
     */
    public void setPop(Gorilla father){
        assert pop == null;
        assert father != null;
        assert !father.isFemale();
        pop = father;
        pop.children++;
    }

    /**
     * Constructor: a new Main.Gorilla with name n, birth year y, birth month m, gender g,<br>
     * mother mother, father father, and no children.<br>
     * Precondition: n has at least one character in it, m is 1 for Jan, 2 for Feb, etc., <br>
     * g is 'f' or 'm' for female or male, mother is non-null and female, and <br>
     * father is non-null and male.
     */
    public Gorilla(String n, int y, int m, char g, Gorilla mother, Gorilla father){
        assert n != null && n.length() >= 1;
        assert m >= 1 && m <= 12;
        assert g == 'f' || g == 'm';
        assert mother != null && mother.isFemale();
        assert father != null && !father.isFemale();
        name = n;
        year = y;
        month = m;
        gender = g;
        setMom(mother);
        setPop(father);
    }

    /**
     * "r is not null and this gorilla was born before r."
     * @param r is a Main.Gorilla object
     */
    public boolean isOlder(Gorilla r){
        return r != null && (year < r.year || month < r.month && year == r.year );
    }

    /**
     * "this gorilla and r are siblings." <br>
     * Precondition: r is not null, this Main.Gorilla is not r
     * @param r
     * @return
     */
    public boolean areSiblings(Gorilla r){
        assert r != null;
        return this != r && (mom == r.mom && pop == r.pop);
    }





}
