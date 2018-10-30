package week9.second;

public abstract class Note implements Readable,Translatable {
    int pages;
    int year;
    String author;
    String language;
    public Note(){
        pages=0;
        year=0;
        author="";
        language="";
    }
    public Note(int pages,int year,String name,String lang){
        this.pages=pages;
        this.year=year;
        author=name;
        language=lang;
    }

    @Override
    public boolean canRead() {
        if(pages>0)
            return true;
        return false;
    }

    @Override
    public boolean canTranslate(String lang2) {
        if(language.equals("English")&&lang2.equals("Russian"))
            return true;
        return false;
    }
}
