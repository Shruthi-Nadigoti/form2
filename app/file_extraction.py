import zipfile,tarfile,os,shutil
def extract_files(fullpath,filename):
    name=filename.rsplit('.',1)[0].lower()+"1"  #this shoud be replaced with project name(unic)
    actual_name=""
    x=[]
    if  filename.rsplit('.', 1)[1].lower()=="zip":
    	 zfile = zipfile.ZipFile(fullpath+"/"+filename)
         zfile.extractall(fullpath+"/")
         actual_name=filename[:filename.rfind("zip")-1]
         x=zfile.namelist()
    elif "tar.gz" in filename and filename.rsplit('.', 1)[1].lower()=="gz":
         tar = tarfile.open(fullpath+"/"+filename,'r:gz')
         tar.extractall(fullpath+"/")
         actual_name=filename[:filename.rfind("tar.gz")-1]
         x=tar.getnames()

    os.makedirs(fullpath+"/"+name+"/images")
    os.makedirs(fullpath+"/"+name+"/videos")
    os.makedirs(fullpath+"/"+name+"/audios")
    os.makedirs(fullpath+"/"+name+"/documents")
    m=-1;
    for f in x:
         srcfullpath = fullpath+ "/" + f
         print srcfullpath
         if('.' in f):
                m=m+1
                f_name=srcfullpath[srcfullpath.rfind('/')+1:]
                #f_name_only=f_name[:f_name.rfind('.')]
                if(f.rsplit('.',1)[1].lower() in ['png','gif','jpeg','jpg']):
                    dst =fullpath+"/"+name+"/images"
                    shutil.move(srcfullpath, dst)
                    os.rename(dst+"/"+f_name,(dst+"/"+str(m)+f_name))
                elif(f.rsplit('.',1)[1].lower() in ['pdf','doc','txt','odt','docx']):
                    dst =fullpath+"/"+name+"/documents"
                    shutil.move(srcfullpath, dst)
                    os.rename(dst+"/"+f_name,(dst+"/"+str(m)+f_name))
                elif(f.rsplit('.',1)[1].lower() in ['mp4','mkv']):
                    dst =fullpath+"/"+name+"/videos"
                    shutil.move(srcfullpath, dst)
                    os.rename(dst+"/"+f_name,(dst+"/"+str(m)+f_name))
                elif(f.rsplit('.',1)[1].lower() in ['mp3']):
                    dst =fullpath+"/"+name+"/audio"
                    shutil.move(srcfullpath, dst)
                    os.rename(dst+"/"+f_name,(dst+"/"+str(m)+f_name))

    dictcount={}

    dirListing = os.listdir(fullpath+"/"+name+"/images")
    if(len(dirListing)!=0):
        dictcount.update({'Images':len(dirListing)})
    dirListing = os.listdir(fullpath+"/"+name+"/videos")
    if(len(dirListing)!=0):
        dictcount.update({'Videos':len(dirListing)})
    dirListing = os.listdir(fullpath+"/"+name+"/documents")
    if(len(dirListing)!=0):
        dictcount.update({'Documents':len(dirListing)})
    dirListing = os.listdir(fullpath+"/"+name+"/audios")
    if(len(dirListing)!=0):
        dictcount.update({'Audio':len(dirListing)})
    dictcount.update({'zzz':fullpath+"/"+name})
    print fullpath+"/"+actual_name
    if os.path.exists(fullpath+"/"+actual_name):
        shutil.rmtree(fullpath+"/"+actual_name)
    if os.path.exists(fullpath+"/"+filename):
        os.remove(fullpath+"/"+filename)
    return dictcount
