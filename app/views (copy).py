from flask import render_template, flash, redirect
from app import app
from .forms import *
import os
from flask import  request, redirect, url_for
from werkzeug.utils import secure_filename
from flask import send_from_directory
import zipfile,subprocess,tarfile,glob,shutil

UPLOAD_FOLDER = '/home/shruthi/Flask/Form2/app/uploads'
ALLOWED_EXTENSIONS = set(['zip', 'tar','gz','tar.gz', 'pdf','jpg', 'jpeg', 'gif'])

app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

@app.route('/questions', methods=['GET', 'POST'])
def questions():
    if request.method == 'POST':
        print(request.form.getlist('hello'))
        print(request.form.getlist('add'))
        return "success"
    arr=["Tag the Image","Describe the image","Count the number of human beings"]
    return  render_template('tags.html',arr=arr)

@app.route('/select_type',methods=['GET', 'POST'])
def select_type():
	if request.method == 'POST':
       		 print(request.form.getlist('selecttype'))
        	 return  redirect(url_for('questions'))
 	arr=["Images","videos","Documents","Audio"]
    	return  render_template('select_type.html',arr=arr)



@app.route('/uploads/<filename>')
def uploaded_file(filename):
    return send_from_directory(app.config['UPLOAD_FOLDER'],
                               filename)

def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS
@app.route('/files')
def files():
   form=UploadFile()
   return render_template('import.html',
                           title='Import File',
                           form=form)
@app.route('/import', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        # check if the post request has the file part
        if 'file' not in request.files:
            flash('No file part')
            return redirect(request.url)
        file = request.files['file']
        # if user does not select file, browser also
        # submit a empty part without filename
        if file.filename == '':
            flash('No selected file')
            return redirect(request.url)
        if file and allowed_file(file.filename):
            filename = secure_filename(file.filename)
            file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
            zipobj=extract_files(app.config['UPLOAD_FOLDER'],filename);
            #print(zipobj)
            return redirect(url_for('select_type'))
    form=UploadFile()
    return render_template('import.html',form=form)

def extract_files(fullpath,filename):
    name=filename.rsplit('.')[0].lower()
    print fullpath+name
    os.makedirs(fullpath+"/"+name)
    os.makedirs(fullpath+"/"+name+"/images")
    os.makedirs(fullpath+"/"+name+"/videos")
    os.makedirs(fullpath+"/"+name+"/audios")
    os.makedirs(fullpath+"/"+name+"/documents")
    #os.makedirs(fullpath+"/"+name+"/copy")
    if filename.rsplit('.', 1)[1].lower()=="zip":
    	 zfile = zipfile.ZipFile(fullpath+"/"+filename)
         zfile.extractall(fullpath+"/"+name+"/")
    elif "tar.gz" in filename and filename.rsplit('.', 1)[1].lower()=="gz":
         tar = tarfile.open(fullpath+"/"+filename)
         tar.extractall(path=fullpath+"/"+name+"/")

    src =fullpath+"/"+name+"/"+name
    listOfFiles = os.listdir(src)
    for f in listOfFiles:
         srcfullpath = src + "/" + f
         if('.' in f):
                if(f.rsplit('.',1)[1].lower() in ['png','gif','jpeg','jpg']):
                    dst =fullpath+"/"+name+"/images"
                    #subprocess.Popen("mv" + " " + srcfullpath+ " " + dst,shell=True)
                    shutil.move(srcfullpath, dst)
                elif(f.rsplit('.',1)[1].lower() in ['pdf','doc']):
                    dst =fullpath+"/"+name+"/documents"
                    #subprocess.Popen("mv" + " " + srcfullpath+ " " + dst,shell=True)
                    shutil.move(srcfullpath, dst)
                elif(f.rsplit('.',1)[1].lower() in ['mp4']):
                    dst =fullpath+"/"+name+"/videos"
                    #subprocess.Popen("mv" + " " + srcfullpath+ " " + dst,shell=True)
                    shutil.move(srcfullpath, dst)
                elif(f.rsplit('.',1)[1].lower() in ['mp3']):
                    dst =fullpath+"/"+name+"/audio"
                    #subprocess.Popen("mv" + " " + srcfullpath+ " " + dst,shell=True)
                    shutil.move(srcfullpath, dst)

    dictcount={}
    dirListing = os.listdir(fullpath+"/"+name+"/images")
    dictcount.update({'images':len(dirListing)})
    dirListing = os.listdir(fullpath+"/"+name+"/videos")
    dictcount.update({'videos':len(dirListing)})
    dirListing = os.listdir(fullpath+"/"+name+"/documents")
    dictcount.update({'documents':len(dirListing)})
    dirListing = os.listdir(fullpath+"/"+name+"/audios")
    dictcount.update({'audios':len(dirListing)})
    print dictcount
