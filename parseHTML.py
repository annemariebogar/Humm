# this program parses the HTML doc of each article
import urllib2
import json
from bs4 import BeautifulSoup

def HTML_aljazeera(link):
    response = urllib2.urlopen(link)
    html = response.read()
    
    #file_handler = open(link)
    # doc = """<html><head><title>The Dormouse's story</title></head><body><p class="title"><b>The Dormouse's story</b></p><p class="story">Once upon a time there were three little sisters; and their names were <a href="http://example.com/elsie" class="sister" id="link1">Elsie</a>, <a href="http://example.com/lacie" class="sister" id="link2>Lacie</a> and <a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>; and they lived at the bottom of a well.</p><p class="story>...</p></body></html>"""
    text = ""
    soup = BeautifulSoup(html, "html.parser")
    for p_tag in soup.find_all('div', class_="text"):
        text = text + " " + p_tag.text

    #tags_included = soup.find_all('div', class_="text")
    
    #f = open("HTMLdoc.html", 'r+')
    #f.write(tags_included)
    #tagged_html = f.read()
    
    #bs = BeautifulSoup(tagged_html, "html.parser")
    #text = bs.get_text()
    #soup.a.decompose()
    #text = soup.get_text('p')
    #text = soup.find_all('div', class_="text")
    
    #text = soup.find_all("p")

    #f.close()

    return text

def HTML_npr(link):
    bad1 = 'hide caption'
    bad2 = 'Please keep your community civil.'
    bad7 = 'All comments must follow the NPR.org Community rules and Terms of Use'
    bad10 = 'All comments must follow the NPR.org Community rules and terms of use, and will be moderated prior to posting'
    bad8 = 'NPR reserves the right to use the comments we receive, in whole or in part, and to use the commenter\'s name and location, in any medium.'
    bad9 = 'See also the Terms of Use, Privacy Policy and Community FAQ.'
    bad3 = 'NPR thanks our sponsors'
    bad4 = 'Become an NPR sponsor'
    bad5 = 'Support The Programs You Love'
    bad6 = 'document.write(new Date().getFullYear()); NPR'
    
    response = urllib2.urlopen(link)
    html = response.read()

    text = ""
    soup = BeautifulSoup(html, "html.parser")
    for p_tag in soup.find_all('p'):
        text = text + " " + p_tag.text

    if bad1 in text:
        print('in')
        text = text.replace(bad1, "")
    if bad2 in text:
        print('in')
        text = text.replace(bad2, "")
    if bad3 in text:
        print('in')
        text = text.replace(bad3, "")
    if bad4 in text:
        text = text.replace(bad4, "")
    if bad5 in text:
        text = text.replace(bad5, "")
    if bad6 in text:
        text = text.replace(bad6, "")
    if bad7 in text:
        text = text.replace(bad7, "")
    if bad8 in text:
        text = text.replace(bad8, "")
    if bad9 in text:
        text = text.replace(bad9, "")
    if bad10 in text:
        text = text.replace(bad10, "")
        
    return text
    
def HTML_guardian(link):
    bad1 = 'Last modified on'
    bad2 = 'Sign in'
    bad3 = 'or create your Guardian account to join the discussion.'
    bad4 = 'This discussion is closed for comments.'
    bad5 = 're doing some maintenance right now.'
    bad6 = 'You can still read comments, but please come back later to add your own.'
    bad7 = 'Commenting has been disabled for this account (why?)'
    
    response = urllib2.urlopen(link)
    html = response.read()

    text = ""
    soup = BeautifulSoup(html, "html.parser")
    for p_tag in soup.find_all('p'):
        text = text + " " + p_tag.text

    if bad1 in text:
        text = text.replace(bad1, "")
    if bad2 in text:
        text = text.replace(bad2, "")
    if bad3 in text:
        text = text.replace(bad3, "")
    if bad4 in text:
        text = text.replace(bad4, "")
    if bad5 in text:
        text = text.replace(bad5, "")
    if bad6 in text:
        text = text.replace(bad6, "")
    if bad7 in text:
        text = text.replace(bad7, "")

    return text

def HTML_spiegel(link):
    bad1 = 'if (typeof ADI != \'undefined\') ADI.ad(\'content_ad_1\');'
    bad2 = 'if (typeof ADI != \'undefined\') ADI.ad(\'content_ad_2\');'
    bad3 = 'About the Author'
    bad4 = 'Post to other social networks'
    bad5 = 'Stay informed with our free news services:'
    bad6 = 'SPIEGEL ONLINE 2015'
    bad7 = 'All Rights Reserved'
    bad8 = 'Reproduction only allowed with the permission of SPIEGELnet GmbH'
    bad9 = 'Click on the links below for more information about DER SPIEGEL\'s history, how to subscribe or purchase the latest issue of the German-language edition in print or digital form or how to obtain rights to reprint SPIEGEL articles.'
    bad10 = 'Please activate javascript'

    response = urllib2.urlopen(link)
    html = response.read()

    text = ""
    soup = BeautifulSoup(html, "html.parser")
    for p_tag in soup.find_all('p'):
        text = text + " " + p_tag.text

    if bad1 in text:
        text = text.replace(bad1, "")
    if bad2 in text:
        text = text.replace(bad2, "")
    if bad3 in text:
        text = text.replace(bad3, "")
    if bad4 in text:
        text = text.replace(bad4, "")
    if bad5 in text:
        text = text.replace(bad5, "")
    if bad6 in text:
        text = text.replace(bad6, "")
    if bad7 in text:
        text = text.replace(bad7, "")
    if bad8 in text:
        text = text.replace(bad8, "")
    if bad9 in text:
        text = text.replace(bad9, "")
    if bad10 in text:
        text = text.replace(bad10, "")
        
    return text

def HTML_bbc(link):
    response = urllib2.urlopen(link)
    html = response.read()

    text = ""
    soup = BeautifulSoup(html, "html.parser")
    for p_tag in soup.find_all('p'):
        text = text + " " + p_tag.text
    for ex_tag in soup.find_all('p', class_='bold-image-promo_summary'):
        excess = ex_tag.text
        print(excess)
        if excess in text:
            text = text.replace(excess, "")

    return text

def HTML_ap(link):
    response = urllib2.urlopen(link)
    html = response.read()

    text = ""
    soup = BeautifulSoup(html, "html.parser")
    for p_tag in soup.find_all('P'):
        text = text + " " + p_tag.text

    return text

def HTML_cnn(link):
    response = urllib2.urlopen(link)
    html = response.read()

    text = ""
    soup = BeautifulSoup(html, "html.parser")

    for p_tag in soup.find_all("p"):
        text = text + " " + p_tag.text

    return text

def main():
    #http_link = 'http://www.npr.org/sections/goatsandsoda/2015/07/08/419823015/this-must-be-a-first-alpacas-blessed-in-nations-capital?utm_medium=RSS&amp;utm_campaign=news'
    #http_link = "HTMLdoc.html"
    #http_link = 'http://america.aljazeera.com/articles/2015/7/8/serving-secret-transgender-us-military.html'
    #http_link = 'http://npr.org/sections/thetwo-way/2015/07/08/421223972/a-day-filled-with-market-jitters-but-not-panic?utm_medium=RSS&amp;utm_campaign=news'
    #http_link = 'http://www.theguardian.com/business/2015/jul/08/china-stock-markets-continue-nosedive-as-regulator-warns-of-panic'
    #http_link = 'http://www.spiegel.de/international/world/greece-essay-by-barry-eichengreen-a-1042609.html#ref=rss'
    #http_link = 'http://www.spiegel.de/international/germany/editorial-merkel-must-end-devel-s-pact-with-america-a-1042573.html#ref=rss'
    #http_link = 'http://www.bbc.co.uk/news/world-europe-33441183#sa-ns_mchannel=rss&amp;ns_source=PublicRSS20-sa'
    #http_link = 'http://hosted2.ap.org/APDEFAULT/cae69a7523db45408eeb2b3a98c0c9c5/Article_2015-07-09-EU--Greece-Bailout/id-0617674c9fcb417cb6fbaaaec16dd339' 
    #http_link = 'http://rss.cnn.com/~r/rss/cnn_topstories/~3/C3sRQkSEwmY/index.html'
    print("I'm in Python!!!")
    f = open('Link.txt', 'r')
    http_link = f.read()
    f.close()
    #HTML_aljazeera(http_link)
    text_main = HTML_aljazeera(http_link)
    #print(text_main.encode('utf-8'))
    article_text = json.dumps(text_main.encode('utf-8'))
    #r = open('Content.txt', 'r+')
    #r.write(text_main.encode('utf-8'))
    #print(r.read())
    #r.close()
    print( article_text )

main()
