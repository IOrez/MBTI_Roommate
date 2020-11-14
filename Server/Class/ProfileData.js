module.exports =class ProfileData{
    constructor(id,password,pname,pgender,pmbti,pdormitory,univ,email,psmoke,pcomment,page,pcontact,pstime,pshour,hasMatchBefore,isMatched)
    {
        this.id = id;
        this.password = password;
        this.pname = pname;
        this.pgender = pgender;
        this.pmbti = pmbti;
        this.pdormitory = pdormitory;
        this.univ = univ;
        this.email = email;
        this.psmoke = psmoke;
        this.pcomment = pcomment;
        this.page = page;
        this.pcontact = pcontact;
        this.pstime = pstime;
        this.pshour = pshour;
        this.hasMatchBefore = hasMatchBefore;
        this.isMatched = isMatched;
    }
};

