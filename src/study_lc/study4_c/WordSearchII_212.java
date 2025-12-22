package study_lc.study4_c;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII_212 {
    public static void main(String[] args) {
//        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = new String[]{"oath","pea","eat","rain"};

//        char[][] board = new char[][]{{'m','b','c','d','e','f','g','h','i','j','k','l'},{'n','a','a','a','a','a','a','a','a','a','a','a'},{'o','a','a','a','a','a','a','a','a','a','a','a'},{'p','a','a','a','a','a','a','a','a','a','a','a'},{'q','a','a','a','a','a','a','a','a','a','a','a'},{'r','a','a','a','a','a','a','a','a','a','a','a'},{'s','a','a','a','a','a','a','a','a','a','a','a'},{'t','a','a','a','a','a','a','a','a','a','a','a'},{'u','a','a','a','a','a','a','a','a','a','a','a'},{'v','a','a','a','a','a','a','a','a','a','a','a'},{'w','a','a','a','a','a','a','a','a','a','a','a'},{'x','y','z','a','a','a','a','a','a','a','a','a'}};
//        String[] words = new String[]{"aaaaaaaaaa","baaaaaaaaa","caaaaaaaaa","daaaaaaaaa","eaaaaaaaaa","faaaaaaaaa","gaaaaaaaaa","haaaaaaaaa","iaaaaaaaaa","jaaaaaaaaa","kaaaaaaaaa","laaaaaaaaa","maaaaaaaaa","naaaaaaaaa","oaaaaaaaaa","paaaaaaaaa","qaaaaaaaaa","raaaaaaaaa","saaaaaaaaa","taaaaaaaaa","uaaaaaaaaa","vaaaaaaaaa","waaaaaaaaa","xaaaaaaaaa","yaaaaaaaaa","zaaaaaaaaa","abaaaaaaaa","bbaaaaaaaa","cbaaaaaaaa","dbaaaaaaaa","ebaaaaaaaa","fbaaaaaaaa","gbaaaaaaaa","hbaaaaaaaa","ibaaaaaaaa","jbaaaaaaaa","kbaaaaaaaa","lbaaaaaaaa","mbaaaaaaaa","nbaaaaaaaa","obaaaaaaaa","pbaaaaaaaa","qbaaaaaaaa","rbaaaaaaaa","sbaaaaaaaa","tbaaaaaaaa","ubaaaaaaaa","vbaaaaaaaa","wbaaaaaaaa","xbaaaaaaaa","ybaaaaaaaa","zbaaaaaaaa","acaaaaaaaa","bcaaaaaaaa","ccaaaaaaaa","dcaaaaaaaa","ecaaaaaaaa","fcaaaaaaaa","gcaaaaaaaa","hcaaaaaaaa","icaaaaaaaa","jcaaaaaaaa","kcaaaaaaaa","lcaaaaaaaa","mcaaaaaaaa","ncaaaaaaaa","ocaaaaaaaa","pcaaaaaaaa","qcaaaaaaaa","rcaaaaaaaa","scaaaaaaaa","tcaaaaaaaa","ucaaaaaaaa","vcaaaaaaaa","wcaaaaaaaa","xcaaaaaaaa","ycaaaaaaaa","zcaaaaaaaa","adaaaaaaaa","bdaaaaaaaa","cdaaaaaaaa","ddaaaaaaaa","edaaaaaaaa","fdaaaaaaaa","gdaaaaaaaa","hdaaaaaaaa","idaaaaaaaa","jdaaaaaaaa","kdaaaaaaaa","ldaaaaaaaa","mdaaaaaaaa","ndaaaaaaaa","odaaaaaaaa","pdaaaaaaaa","qdaaaaaaaa","rdaaaaaaaa","sdaaaaaaaa","tdaaaaaaaa","udaaaaaaaa","vdaaaaaaaa","wdaaaaaaaa","xdaaaaaaaa","ydaaaaaaaa","zdaaaaaaaa","aeaaaaaaaa","beaaaaaaaa","ceaaaaaaaa","deaaaaaaaa","eeaaaaaaaa","feaaaaaaaa","geaaaaaaaa","heaaaaaaaa","ieaaaaaaaa","jeaaaaaaaa","keaaaaaaaa","leaaaaaaaa","meaaaaaaaa","neaaaaaaaa","oeaaaaaaaa","peaaaaaaaa","qeaaaaaaaa","reaaaaaaaa","seaaaaaaaa","teaaaaaaaa","ueaaaaaaaa","veaaaaaaaa","weaaaaaaaa","xeaaaaaaaa","yeaaaaaaaa","zeaaaaaaaa","afaaaaaaaa","bfaaaaaaaa","cfaaaaaaaa","dfaaaaaaaa","efaaaaaaaa","ffaaaaaaaa","gfaaaaaaaa","hfaaaaaaaa","ifaaaaaaaa","jfaaaaaaaa","kfaaaaaaaa","lfaaaaaaaa","mfaaaaaaaa","nfaaaaaaaa","ofaaaaaaaa","pfaaaaaaaa","qfaaaaaaaa","rfaaaaaaaa","sfaaaaaaaa","tfaaaaaaaa","ufaaaaaaaa","vfaaaaaaaa","wfaaaaaaaa","xfaaaaaaaa","yfaaaaaaaa","zfaaaaaaaa","agaaaaaaaa","bgaaaaaaaa","cgaaaaaaaa","dgaaaaaaaa","egaaaaaaaa","fgaaaaaaaa","ggaaaaaaaa","hgaaaaaaaa","igaaaaaaaa","jgaaaaaaaa","kgaaaaaaaa","lgaaaaaaaa","mgaaaaaaaa","ngaaaaaaaa","ogaaaaaaaa","pgaaaaaaaa","qgaaaaaaaa","rgaaaaaaaa","sgaaaaaaaa","tgaaaaaaaa","ugaaaaaaaa","vgaaaaaaaa","wgaaaaaaaa","xgaaaaaaaa","ygaaaaaaaa","zgaaaaaaaa","ahaaaaaaaa","bhaaaaaaaa","chaaaaaaaa","dhaaaaaaaa","ehaaaaaaaa","fhaaaaaaaa","ghaaaaaaaa","hhaaaaaaaa","ihaaaaaaaa","jhaaaaaaaa","khaaaaaaaa","lhaaaaaaaa","mhaaaaaaaa","nhaaaaaaaa","ohaaaaaaaa","phaaaaaaaa","qhaaaaaaaa","rhaaaaaaaa","shaaaaaaaa","thaaaaaaaa","uhaaaaaaaa","vhaaaaaaaa","whaaaaaaaa","xhaaaaaaaa","yhaaaaaaaa","zhaaaaaaaa","aiaaaaaaaa","biaaaaaaaa","ciaaaaaaaa","diaaaaaaaa","eiaaaaaaaa","fiaaaaaaaa","giaaaaaaaa","hiaaaaaaaa","iiaaaaaaaa","jiaaaaaaaa","kiaaaaaaaa","liaaaaaaaa","miaaaaaaaa","niaaaaaaaa","oiaaaaaaaa","piaaaaaaaa","qiaaaaaaaa","riaaaaaaaa","siaaaaaaaa","tiaaaaaaaa","uiaaaaaaaa","viaaaaaaaa","wiaaaaaaaa","xiaaaaaaaa","yiaaaaaaaa","ziaaaaaaaa","ajaaaaaaaa","bjaaaaaaaa","cjaaaaaaaa","djaaaaaaaa","ejaaaaaaaa","fjaaaaaaaa","gjaaaaaaaa","hjaaaaaaaa","ijaaaaaaaa","jjaaaaaaaa","kjaaaaaaaa","ljaaaaaaaa","mjaaaaaaaa","njaaaaaaaa","ojaaaaaaaa","pjaaaaaaaa","qjaaaaaaaa","rjaaaaaaaa","sjaaaaaaaa","tjaaaaaaaa","ujaaaaaaaa","vjaaaaaaaa","wjaaaaaaaa","xjaaaaaaaa","yjaaaaaaaa","zjaaaaaaaa","akaaaaaaaa","bkaaaaaaaa","ckaaaaaaaa","dkaaaaaaaa","ekaaaaaaaa","fkaaaaaaaa","gkaaaaaaaa","hkaaaaaaaa","ikaaaaaaaa","jkaaaaaaaa","kkaaaaaaaa","lkaaaaaaaa","mkaaaaaaaa","nkaaaaaaaa","okaaaaaaaa","pkaaaaaaaa","qkaaaaaaaa","rkaaaaaaaa","skaaaaaaaa","tkaaaaaaaa","ukaaaaaaaa","vkaaaaaaaa","wkaaaaaaaa","xkaaaaaaaa","ykaaaaaaaa","zkaaaaaaaa","alaaaaaaaa","blaaaaaaaa","claaaaaaaa","dlaaaaaaaa","elaaaaaaaa","flaaaaaaaa","glaaaaaaaa","hlaaaaaaaa","ilaaaaaaaa","jlaaaaaaaa","klaaaaaaaa","llaaaaaaaa","mlaaaaaaaa","nlaaaaaaaa","olaaaaaaaa","plaaaaaaaa","qlaaaaaaaa","rlaaaaaaaa","slaaaaaaaa","tlaaaaaaaa","ulaaaaaaaa","vlaaaaaaaa","wlaaaaaaaa","xlaaaaaaaa","ylaaaaaaaa","zlaaaaaaaa","amaaaaaaaa","bmaaaaaaaa","cmaaaaaaaa","dmaaaaaaaa","emaaaaaaaa","fmaaaaaaaa","gmaaaaaaaa","hmaaaaaaaa","imaaaaaaaa","jmaaaaaaaa","kmaaaaaaaa","lmaaaaaaaa","mmaaaaaaaa","nmaaaaaaaa","omaaaaaaaa","pmaaaaaaaa","qmaaaaaaaa","rmaaaaaaaa","smaaaaaaaa","tmaaaaaaaa","umaaaaaaaa","vmaaaaaaaa","wmaaaaaaaa","xmaaaaaaaa","ymaaaaaaaa","zmaaaaaaaa","anaaaaaaaa","bnaaaaaaaa","cnaaaaaaaa","dnaaaaaaaa","enaaaaaaaa","fnaaaaaaaa","gnaaaaaaaa","hnaaaaaaaa","inaaaaaaaa","jnaaaaaaaa","knaaaaaaaa","lnaaaaaaaa","mnaaaaaaaa","nnaaaaaaaa","onaaaaaaaa","pnaaaaaaaa","qnaaaaaaaa","rnaaaaaaaa","snaaaaaaaa","tnaaaaaaaa","unaaaaaaaa","vnaaaaaaaa","wnaaaaaaaa","xnaaaaaaaa","ynaaaaaaaa","znaaaaaaaa","aoaaaaaaaa","boaaaaaaaa","coaaaaaaaa","doaaaaaaaa","eoaaaaaaaa","foaaaaaaaa","goaaaaaaaa","hoaaaaaaaa","ioaaaaaaaa","joaaaaaaaa","koaaaaaaaa","loaaaaaaaa","moaaaaaaaa","noaaaaaaaa","ooaaaaaaaa","poaaaaaaaa","qoaaaaaaaa","roaaaaaaaa","soaaaaaaaa","toaaaaaaaa","uoaaaaaaaa","voaaaaaaaa","woaaaaaaaa","xoaaaaaaaa","yoaaaaaaaa","zoaaaaaaaa","apaaaaaaaa","bpaaaaaaaa","cpaaaaaaaa","dpaaaaaaaa","epaaaaaaaa","fpaaaaaaaa","gpaaaaaaaa","hpaaaaaaaa","ipaaaaaaaa","jpaaaaaaaa","kpaaaaaaaa","lpaaaaaaaa","mpaaaaaaaa","npaaaaaaaa","opaaaaaaaa","ppaaaaaaaa","qpaaaaaaaa","rpaaaaaaaa","spaaaaaaaa","tpaaaaaaaa","upaaaaaaaa","vpaaaaaaaa","wpaaaaaaaa","xpaaaaaaaa","ypaaaaaaaa","zpaaaaaaaa","aqaaaaaaaa","bqaaaaaaaa","cqaaaaaaaa","dqaaaaaaaa","eqaaaaaaaa","fqaaaaaaaa","gqaaaaaaaa","hqaaaaaaaa","iqaaaaaaaa","jqaaaaaaaa","kqaaaaaaaa","lqaaaaaaaa","mqaaaaaaaa","nqaaaaaaaa","oqaaaaaaaa","pqaaaaaaaa","qqaaaaaaaa","rqaaaaaaaa","sqaaaaaaaa","tqaaaaaaaa","uqaaaaaaaa","vqaaaaaaaa","wqaaaaaaaa","xqaaaaaaaa","yqaaaaaaaa","zqaaaaaaaa","araaaaaaaa","braaaaaaaa","craaaaaaaa","draaaaaaaa","eraaaaaaaa","fraaaaaaaa","graaaaaaaa","hraaaaaaaa","iraaaaaaaa","jraaaaaaaa","kraaaaaaaa","lraaaaaaaa","mraaaaaaaa","nraaaaaaaa","oraaaaaaaa","praaaaaaaa","qraaaaaaaa","rraaaaaaaa","sraaaaaaaa","traaaaaaaa","uraaaaaaaa","vraaaaaaaa","wraaaaaaaa","xraaaaaaaa","yraaaaaaaa","zraaaaaaaa","asaaaaaaaa","bsaaaaaaaa","csaaaaaaaa","dsaaaaaaaa","esaaaaaaaa","fsaaaaaaaa","gsaaaaaaaa","hsaaaaaaaa","isaaaaaaaa","jsaaaaaaaa","ksaaaaaaaa","lsaaaaaaaa","msaaaaaaaa","nsaaaaaaaa","osaaaaaaaa","psaaaaaaaa","qsaaaaaaaa","rsaaaaaaaa","ssaaaaaaaa","tsaaaaaaaa","usaaaaaaaa","vsaaaaaaaa","wsaaaaaaaa","xsaaaaaaaa","ysaaaaaaaa","zsaaaaaaaa","ataaaaaaaa","btaaaaaaaa","ctaaaaaaaa","dtaaaaaaaa","etaaaaaaaa","ftaaaaaaaa","gtaaaaaaaa","htaaaaaaaa","itaaaaaaaa","jtaaaaaaaa","ktaaaaaaaa","ltaaaaaaaa","mtaaaaaaaa","ntaaaaaaaa","otaaaaaaaa","ptaaaaaaaa","qtaaaaaaaa","rtaaaaaaaa","staaaaaaaa","ttaaaaaaaa","utaaaaaaaa","vtaaaaaaaa","wtaaaaaaaa","xtaaaaaaaa","ytaaaaaaaa","ztaaaaaaaa","auaaaaaaaa","buaaaaaaaa","cuaaaaaaaa","duaaaaaaaa","euaaaaaaaa","fuaaaaaaaa","guaaaaaaaa","huaaaaaaaa","iuaaaaaaaa","juaaaaaaaa","kuaaaaaaaa","luaaaaaaaa","muaaaaaaaa","nuaaaaaaaa","ouaaaaaaaa","puaaaaaaaa","quaaaaaaaa","ruaaaaaaaa","suaaaaaaaa","tuaaaaaaaa","uuaaaaaaaa","vuaaaaaaaa","wuaaaaaaaa","xuaaaaaaaa","yuaaaaaaaa","zuaaaaaaaa","avaaaaaaaa","bvaaaaaaaa","cvaaaaaaaa","dvaaaaaaaa","evaaaaaaaa","fvaaaaaaaa","gvaaaaaaaa","hvaaaaaaaa","ivaaaaaaaa","jvaaaaaaaa","kvaaaaaaaa","lvaaaaaaaa","mvaaaaaaaa","nvaaaaaaaa","ovaaaaaaaa","pvaaaaaaaa","qvaaaaaaaa","rvaaaaaaaa","svaaaaaaaa","tvaaaaaaaa","uvaaaaaaaa","vvaaaaaaaa","wvaaaaaaaa","xvaaaaaaaa","yvaaaaaaaa","zvaaaaaaaa","awaaaaaaaa","bwaaaaaaaa","cwaaaaaaaa","dwaaaaaaaa","ewaaaaaaaa","fwaaaaaaaa","gwaaaaaaaa","hwaaaaaaaa","iwaaaaaaaa","jwaaaaaaaa","kwaaaaaaaa","lwaaaaaaaa","mwaaaaaaaa","nwaaaaaaaa","owaaaaaaaa","pwaaaaaaaa","qwaaaaaaaa","rwaaaaaaaa","swaaaaaaaa","twaaaaaaaa","uwaaaaaaaa","vwaaaaaaaa","wwaaaaaaaa","xwaaaaaaaa","ywaaaaaaaa","zwaaaaaaaa","axaaaaaaaa","bxaaaaaaaa","cxaaaaaaaa","dxaaaaaaaa","exaaaaaaaa","fxaaaaaaaa","gxaaaaaaaa","hxaaaaaaaa","ixaaaaaaaa","jxaaaaaaaa","kxaaaaaaaa","lxaaaaaaaa","mxaaaaaaaa","nxaaaaaaaa","oxaaaaaaaa","pxaaaaaaaa","qxaaaaaaaa","rxaaaaaaaa","sxaaaaaaaa","txaaaaaaaa","uxaaaaaaaa","vxaaaaaaaa","wxaaaaaaaa","xxaaaaaaaa","yxaaaaaaaa","zxaaaaaaaa","ayaaaaaaaa","byaaaaaaaa","cyaaaaaaaa","dyaaaaaaaa","eyaaaaaaaa","fyaaaaaaaa","gyaaaaaaaa","hyaaaaaaaa","iyaaaaaaaa","jyaaaaaaaa","kyaaaaaaaa","lyaaaaaaaa","myaaaaaaaa","nyaaaaaaaa","oyaaaaaaaa","pyaaaaaaaa","qyaaaaaaaa","ryaaaaaaaa","syaaaaaaaa","tyaaaaaaaa","uyaaaaaaaa","vyaaaaaaaa","wyaaaaaaaa","xyaaaaaaaa","yyaaaaaaaa","zyaaaaaaaa","azaaaaaaaa","bzaaaaaaaa","czaaaaaaaa","dzaaaaaaaa","ezaaaaaaaa","fzaaaaaaaa","gzaaaaaaaa","hzaaaaaaaa","izaaaaaaaa","jzaaaaaaaa","kzaaaaaaaa","lzaaaaaaaa","mzaaaaaaaa","nzaaaaaaaa","ozaaaaaaaa","pzaaaaaaaa","qzaaaaaaaa","rzaaaaaaaa","szaaaaaaaa","tzaaaaaaaa","uzaaaaaaaa","vzaaaaaaaa","wzaaaaaaaa","xzaaaaaaaa","yzaaaaaaaa","zzaaaaaaaa"};


        char[][] board = new char[][]{{'m','b','c','d','e','f','g','h','i','j','k','l'},{'n','a','a','a','a','a','a','a','a','a','a','a'},{'o','a','a','a','a','a','a','a','a','a','a','a'},{'p','a','a','a','a','a','a','a','a','a','a','a'},{'q','a','a','a','a','a','a','a','a','a','a','a'},{'r','a','a','a','a','a','a','a','a','a','a','a'},{'s','a','a','a','a','a','a','a','a','a','a','a'},{'t','a','a','a','a','a','a','a','a','a','a','a'},{'u','a','a','a','a','a','a','a','a','a','a','a'},{'v','a','a','a','a','a','a','a','a','a','a','a'},{'w','a','a','a','a','a','a','a','a','a','a','a'},{'x','y','z','a','a','a','a','a','a','a','a','a'}};
        String[] words = new String[]{"aaaaaaaaaa","aaaaaaaaab","aaaaaaaaac","aaaaaaaaad","aaaaaaaaae","aaaaaaaaaf","aaaaaaaaag","aaaaaaaaah","aaaaaaaaai","aaaaaaaaaj","aaaaaaaaak","aaaaaaaaal","aaaaaaaaam","aaaaaaaaan","aaaaaaaaao","aaaaaaaaap","aaaaaaaaaq","aaaaaaaaar","aaaaaaaaas","aaaaaaaaat","aaaaaaaaau","aaaaaaaaav","aaaaaaaaaw","aaaaaaaaax","aaaaaaaaay","aaaaaaaaaz","aaaaaaaaba","aaaaaaaabb","aaaaaaaabc","aaaaaaaabd","aaaaaaaabe","aaaaaaaabf","aaaaaaaabg","aaaaaaaabh","aaaaaaaabi","aaaaaaaabj","aaaaaaaabk","aaaaaaaabl","aaaaaaaabm","aaaaaaaabn","aaaaaaaabo","aaaaaaaabp","aaaaaaaabq","aaaaaaaabr","aaaaaaaabs","aaaaaaaabt","aaaaaaaabu","aaaaaaaabv","aaaaaaaabw","aaaaaaaabx","aaaaaaaaby","aaaaaaaabz","aaaaaaaaca","aaaaaaaacb","aaaaaaaacc","aaaaaaaacd","aaaaaaaace","aaaaaaaacf","aaaaaaaacg","aaaaaaaach","aaaaaaaaci","aaaaaaaacj","aaaaaaaack","aaaaaaaacl","aaaaaaaacm","aaaaaaaacn","aaaaaaaaco","aaaaaaaacp","aaaaaaaacq","aaaaaaaacr","aaaaaaaacs","aaaaaaaact","aaaaaaaacu","aaaaaaaacv","aaaaaaaacw","aaaaaaaacx","aaaaaaaacy","aaaaaaaacz","aaaaaaaada","aaaaaaaadb","aaaaaaaadc","aaaaaaaadd","aaaaaaaade","aaaaaaaadf","aaaaaaaadg","aaaaaaaadh","aaaaaaaadi","aaaaaaaadj","aaaaaaaadk","aaaaaaaadl","aaaaaaaadm","aaaaaaaadn","aaaaaaaado","aaaaaaaadp","aaaaaaaadq","aaaaaaaadr","aaaaaaaads","aaaaaaaadt","aaaaaaaadu","aaaaaaaadv","aaaaaaaadw","aaaaaaaadx","aaaaaaaady","aaaaaaaadz","aaaaaaaaea","aaaaaaaaeb","aaaaaaaaec","aaaaaaaaed","aaaaaaaaee","aaaaaaaaef","aaaaaaaaeg","aaaaaaaaeh","aaaaaaaaei","aaaaaaaaej","aaaaaaaaek","aaaaaaaael","aaaaaaaaem","aaaaaaaaen","aaaaaaaaeo","aaaaaaaaep","aaaaaaaaeq","aaaaaaaaer","aaaaaaaaes","aaaaaaaaet","aaaaaaaaeu","aaaaaaaaev","aaaaaaaaew","aaaaaaaaex","aaaaaaaaey","aaaaaaaaez","aaaaaaaafa","aaaaaaaafb","aaaaaaaafc","aaaaaaaafd","aaaaaaaafe","aaaaaaaaff","aaaaaaaafg","aaaaaaaafh","aaaaaaaafi","aaaaaaaafj","aaaaaaaafk","aaaaaaaafl","aaaaaaaafm","aaaaaaaafn","aaaaaaaafo","aaaaaaaafp","aaaaaaaafq","aaaaaaaafr","aaaaaaaafs","aaaaaaaaft","aaaaaaaafu","aaaaaaaafv","aaaaaaaafw","aaaaaaaafx","aaaaaaaafy","aaaaaaaafz","aaaaaaaaga","aaaaaaaagb","aaaaaaaagc","aaaaaaaagd","aaaaaaaage","aaaaaaaagf","aaaaaaaagg","aaaaaaaagh","aaaaaaaagi","aaaaaaaagj","aaaaaaaagk","aaaaaaaagl","aaaaaaaagm","aaaaaaaagn","aaaaaaaago","aaaaaaaagp","aaaaaaaagq","aaaaaaaagr","aaaaaaaags","aaaaaaaagt","aaaaaaaagu","aaaaaaaagv","aaaaaaaagw","aaaaaaaagx","aaaaaaaagy","aaaaaaaagz","aaaaaaaaha","aaaaaaaahb","aaaaaaaahc","aaaaaaaahd","aaaaaaaahe","aaaaaaaahf","aaaaaaaahg","aaaaaaaahh","aaaaaaaahi","aaaaaaaahj","aaaaaaaahk","aaaaaaaahl","aaaaaaaahm","aaaaaaaahn","aaaaaaaaho","aaaaaaaahp","aaaaaaaahq","aaaaaaaahr","aaaaaaaahs","aaaaaaaaht","aaaaaaaahu","aaaaaaaahv","aaaaaaaahw","aaaaaaaahx","aaaaaaaahy","aaaaaaaahz","aaaaaaaaia","aaaaaaaaib","aaaaaaaaic","aaaaaaaaid","aaaaaaaaie","aaaaaaaaif","aaaaaaaaig","aaaaaaaaih","aaaaaaaaii","aaaaaaaaij","aaaaaaaaik","aaaaaaaail","aaaaaaaaim","aaaaaaaain","aaaaaaaaio","aaaaaaaaip","aaaaaaaaiq","aaaaaaaair","aaaaaaaais","aaaaaaaait","aaaaaaaaiu","aaaaaaaaiv","aaaaaaaaiw","aaaaaaaaix","aaaaaaaaiy","aaaaaaaaiz","aaaaaaaaja","aaaaaaaajb","aaaaaaaajc","aaaaaaaajd","aaaaaaaaje","aaaaaaaajf","aaaaaaaajg","aaaaaaaajh","aaaaaaaaji","aaaaaaaajj","aaaaaaaajk","aaaaaaaajl","aaaaaaaajm","aaaaaaaajn","aaaaaaaajo","aaaaaaaajp","aaaaaaaajq","aaaaaaaajr","aaaaaaaajs","aaaaaaaajt","aaaaaaaaju","aaaaaaaajv","aaaaaaaajw","aaaaaaaajx","aaaaaaaajy","aaaaaaaajz","aaaaaaaaka","aaaaaaaakb","aaaaaaaakc","aaaaaaaakd","aaaaaaaake","aaaaaaaakf","aaaaaaaakg","aaaaaaaakh","aaaaaaaaki","aaaaaaaakj","aaaaaaaakk","aaaaaaaakl","aaaaaaaakm","aaaaaaaakn","aaaaaaaako","aaaaaaaakp","aaaaaaaakq","aaaaaaaakr","aaaaaaaaks","aaaaaaaakt","aaaaaaaaku","aaaaaaaakv","aaaaaaaakw","aaaaaaaakx","aaaaaaaaky","aaaaaaaakz","aaaaaaaala","aaaaaaaalb","aaaaaaaalc","aaaaaaaald","aaaaaaaale","aaaaaaaalf","aaaaaaaalg","aaaaaaaalh","aaaaaaaali","aaaaaaaalj","aaaaaaaalk","aaaaaaaall","aaaaaaaalm","aaaaaaaaln","aaaaaaaalo","aaaaaaaalp","aaaaaaaalq","aaaaaaaalr","aaaaaaaals","aaaaaaaalt","aaaaaaaalu","aaaaaaaalv","aaaaaaaalw","aaaaaaaalx","aaaaaaaaly","aaaaaaaalz","aaaaaaaama","aaaaaaaamb","aaaaaaaamc","aaaaaaaamd","aaaaaaaame","aaaaaaaamf","aaaaaaaamg","aaaaaaaamh","aaaaaaaami","aaaaaaaamj","aaaaaaaamk","aaaaaaaaml","aaaaaaaamm","aaaaaaaamn","aaaaaaaamo","aaaaaaaamp","aaaaaaaamq","aaaaaaaamr","aaaaaaaams","aaaaaaaamt","aaaaaaaamu","aaaaaaaamv","aaaaaaaamw","aaaaaaaamx","aaaaaaaamy","aaaaaaaamz","aaaaaaaana","aaaaaaaanb","aaaaaaaanc","aaaaaaaand","aaaaaaaane","aaaaaaaanf","aaaaaaaang","aaaaaaaanh","aaaaaaaani","aaaaaaaanj","aaaaaaaank","aaaaaaaanl","aaaaaaaanm","aaaaaaaann","aaaaaaaano","aaaaaaaanp","aaaaaaaanq","aaaaaaaanr","aaaaaaaans","aaaaaaaant","aaaaaaaanu","aaaaaaaanv","aaaaaaaanw","aaaaaaaanx","aaaaaaaany","aaaaaaaanz","aaaaaaaaoa","aaaaaaaaob","aaaaaaaaoc","aaaaaaaaod","aaaaaaaaoe","aaaaaaaaof","aaaaaaaaog","aaaaaaaaoh","aaaaaaaaoi","aaaaaaaaoj","aaaaaaaaok","aaaaaaaaol","aaaaaaaaom","aaaaaaaaon","aaaaaaaaoo","aaaaaaaaop","aaaaaaaaoq","aaaaaaaaor","aaaaaaaaos","aaaaaaaaot","aaaaaaaaou","aaaaaaaaov","aaaaaaaaow","aaaaaaaaox","aaaaaaaaoy","aaaaaaaaoz","aaaaaaaapa","aaaaaaaapb","aaaaaaaapc","aaaaaaaapd","aaaaaaaape","aaaaaaaapf","aaaaaaaapg","aaaaaaaaph","aaaaaaaapi","aaaaaaaapj","aaaaaaaapk","aaaaaaaapl","aaaaaaaapm","aaaaaaaapn","aaaaaaaapo","aaaaaaaapp","aaaaaaaapq","aaaaaaaapr","aaaaaaaaps","aaaaaaaapt","aaaaaaaapu","aaaaaaaapv","aaaaaaaapw","aaaaaaaapx","aaaaaaaapy","aaaaaaaapz","aaaaaaaaqa","aaaaaaaaqb","aaaaaaaaqc","aaaaaaaaqd","aaaaaaaaqe","aaaaaaaaqf","aaaaaaaaqg","aaaaaaaaqh","aaaaaaaaqi","aaaaaaaaqj","aaaaaaaaqk","aaaaaaaaql","aaaaaaaaqm","aaaaaaaaqn","aaaaaaaaqo","aaaaaaaaqp","aaaaaaaaqq","aaaaaaaaqr","aaaaaaaaqs","aaaaaaaaqt","aaaaaaaaqu","aaaaaaaaqv","aaaaaaaaqw","aaaaaaaaqx","aaaaaaaaqy","aaaaaaaaqz","aaaaaaaara","aaaaaaaarb","aaaaaaaarc","aaaaaaaard","aaaaaaaare","aaaaaaaarf","aaaaaaaarg","aaaaaaaarh","aaaaaaaari","aaaaaaaarj","aaaaaaaark","aaaaaaaarl","aaaaaaaarm","aaaaaaaarn","aaaaaaaaro","aaaaaaaarp","aaaaaaaarq","aaaaaaaarr","aaaaaaaars","aaaaaaaart","aaaaaaaaru","aaaaaaaarv","aaaaaaaarw","aaaaaaaarx","aaaaaaaary","aaaaaaaarz","aaaaaaaasa","aaaaaaaasb","aaaaaaaasc","aaaaaaaasd","aaaaaaaase","aaaaaaaasf","aaaaaaaasg","aaaaaaaash","aaaaaaaasi","aaaaaaaasj","aaaaaaaask","aaaaaaaasl","aaaaaaaasm","aaaaaaaasn","aaaaaaaaso","aaaaaaaasp","aaaaaaaasq","aaaaaaaasr","aaaaaaaass","aaaaaaaast","aaaaaaaasu","aaaaaaaasv","aaaaaaaasw","aaaaaaaasx","aaaaaaaasy","aaaaaaaasz","aaaaaaaata","aaaaaaaatb","aaaaaaaatc","aaaaaaaatd","aaaaaaaate","aaaaaaaatf","aaaaaaaatg","aaaaaaaath","aaaaaaaati","aaaaaaaatj","aaaaaaaatk","aaaaaaaatl","aaaaaaaatm","aaaaaaaatn","aaaaaaaato","aaaaaaaatp","aaaaaaaatq","aaaaaaaatr","aaaaaaaats","aaaaaaaatt","aaaaaaaatu","aaaaaaaatv","aaaaaaaatw","aaaaaaaatx","aaaaaaaaty","aaaaaaaatz","aaaaaaaaua","aaaaaaaaub","aaaaaaaauc","aaaaaaaaud","aaaaaaaaue","aaaaaaaauf","aaaaaaaaug","aaaaaaaauh","aaaaaaaaui","aaaaaaaauj","aaaaaaaauk","aaaaaaaaul","aaaaaaaaum","aaaaaaaaun","aaaaaaaauo","aaaaaaaaup","aaaaaaaauq","aaaaaaaaur","aaaaaaaaus","aaaaaaaaut","aaaaaaaauu","aaaaaaaauv","aaaaaaaauw","aaaaaaaaux","aaaaaaaauy","aaaaaaaauz","aaaaaaaava","aaaaaaaavb","aaaaaaaavc","aaaaaaaavd","aaaaaaaave","aaaaaaaavf","aaaaaaaavg","aaaaaaaavh","aaaaaaaavi","aaaaaaaavj","aaaaaaaavk","aaaaaaaavl","aaaaaaaavm","aaaaaaaavn","aaaaaaaavo","aaaaaaaavp","aaaaaaaavq","aaaaaaaavr","aaaaaaaavs","aaaaaaaavt","aaaaaaaavu","aaaaaaaavv","aaaaaaaavw","aaaaaaaavx","aaaaaaaavy","aaaaaaaavz","aaaaaaaawa","aaaaaaaawb","aaaaaaaawc","aaaaaaaawd","aaaaaaaawe","aaaaaaaawf","aaaaaaaawg","aaaaaaaawh","aaaaaaaawi","aaaaaaaawj","aaaaaaaawk","aaaaaaaawl","aaaaaaaawm","aaaaaaaawn","aaaaaaaawo","aaaaaaaawp","aaaaaaaawq","aaaaaaaawr","aaaaaaaaws","aaaaaaaawt","aaaaaaaawu","aaaaaaaawv","aaaaaaaaww","aaaaaaaawx","aaaaaaaawy","aaaaaaaawz","aaaaaaaaxa","aaaaaaaaxb","aaaaaaaaxc","aaaaaaaaxd","aaaaaaaaxe","aaaaaaaaxf","aaaaaaaaxg","aaaaaaaaxh","aaaaaaaaxi","aaaaaaaaxj","aaaaaaaaxk","aaaaaaaaxl","aaaaaaaaxm","aaaaaaaaxn","aaaaaaaaxo","aaaaaaaaxp","aaaaaaaaxq","aaaaaaaaxr","aaaaaaaaxs","aaaaaaaaxt","aaaaaaaaxu","aaaaaaaaxv","aaaaaaaaxw","aaaaaaaaxx","aaaaaaaaxy","aaaaaaaaxz","aaaaaaaaya","aaaaaaaayb","aaaaaaaayc","aaaaaaaayd","aaaaaaaaye","aaaaaaaayf","aaaaaaaayg","aaaaaaaayh","aaaaaaaayi","aaaaaaaayj","aaaaaaaayk","aaaaaaaayl","aaaaaaaaym","aaaaaaaayn","aaaaaaaayo","aaaaaaaayp","aaaaaaaayq","aaaaaaaayr","aaaaaaaays","aaaaaaaayt","aaaaaaaayu","aaaaaaaayv","aaaaaaaayw","aaaaaaaayx","aaaaaaaayy","aaaaaaaayz","aaaaaaaaza","aaaaaaaazb","aaaaaaaazc","aaaaaaaazd","aaaaaaaaze","aaaaaaaazf","aaaaaaaazg","aaaaaaaazh","aaaaaaaazi","aaaaaaaazj","aaaaaaaazk","aaaaaaaazl","aaaaaaaazm","aaaaaaaazn","aaaaaaaazo","aaaaaaaazp","aaaaaaaazq","aaaaaaaazr","aaaaaaaazs","aaaaaaaazt","aaaaaaaazu","aaaaaaaazv","aaaaaaaazw","aaaaaaaazx","aaaaaaaazy","aaaaaaaazz"};

        List<String> result = findWords(board, words);

        int a = 4;
    }

    public static class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    public static class Trie{
        private final TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode node = root;
            for(char c:word.toCharArray()){
                int index = c- 'a';
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        public boolean startsWith(String prefix){
            TrieNode node = root;
            for(char c:prefix.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null){
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }
    }

    static Trie trie;

    public static List<String> findWords(char[][] board, String[] words) {
        int board_row_len = board.length;
        int board_col_len = board[0].length;
        boolean[][] visited;
        List<String> result = new ArrayList<>();

        trie = new Trie();

        for(int board_row_ind = 0; board_row_ind < board_row_len; board_row_ind++){
            for(int board_col_ind = 0; board_col_ind < board_col_len; board_col_ind++){
                visited = new boolean[board_row_len][board_col_len];
                bfs(board, visited, new StringBuilder(), board_row_ind, board_col_ind, 0);
            }
        }

        for(int i = 0; i < words.length; i++){
            String word = words[i];

            if(trie.startsWith(word)){
                result.add(word);
            }
        }
        return result;
    }

    public static void bfs(char[][] board, boolean[][] visited, StringBuilder curr_word, int curr_x, int curr_y,
                           int counter){
        if(counter > 10){
            return;
        }

        int board_row_len = board.length;
        int board_col_len = board[0].length;
        // System.out.println("1: x: " + curr_x + " - y: " + curr_y);


        if(curr_x < 0 || curr_y < 0 || curr_x >= board_row_len || curr_y >= board_col_len){
            return;
        }

        if(visited[curr_x][curr_y]){
            return;
        }

        visited[curr_x][curr_y] = true;
        // System.out.println("2: x: " + curr_x + " - y: " + curr_y);

        curr_word.append(board[curr_x][curr_y]);
        trie.insert(curr_word.toString());

        bfs(board, visited, curr_word, curr_x + 1, curr_y, counter + 1);
        bfs(board, visited, curr_word, curr_x, curr_y + 1, counter + 1);
        bfs(board, visited, curr_word, curr_x - 1, curr_y, counter + 1);
        bfs(board, visited, curr_word, curr_x, curr_y - 1, counter + 1);

        curr_word.deleteCharAt(curr_word.length() - 1);
        visited[curr_x][curr_y] = false;
    }
}
