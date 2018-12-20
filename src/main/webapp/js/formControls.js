// clear textarea element named "inputtext"
function clearInputTextArea() {
    document.getElementById("inputtext").value = "";
}

//
// SemanticType List controls
//
function selectGroup(semgroup) {
    var elementlist = document.getElementById('iForm').elements;
      
    // using reference to elementlist obtained above
    for (var i=0, len=elementlist.length; i<len; i++) {
        // dbg: console.info(elementlist[i]);
        var nameval = elementlist[i].getAttribute("name");
        if (nameval == "semanticTypeString") {
	    var value = elementlist[i].getAttribute("value");
	    if (semgroup.has(value)) { // 
		elementlist[i].setAttribute("checked","");
	    }
        }
    }    
}				

function selectActivities() {
    // acty, bhvr, dora, evnt, gora, inbe, mcha, ocac, socb
    let group = new Set();
    group.add('acty');
    group.add('bhvr');
    group.add('dora');
    group.add('evnt');
    group.add('gora');
    group.add('inbe');
    group.add('mcha');
    group.add('ocac');
    group.add('socb');
    selectGroup(group);
}

function selectAnatomy() {
    // anst, blor, bpoc, bsoj, bdsu, bdsy, cell, celc, emst, ffas, tisu
    let group = new Set();
    group.add('anst');
    group.add('blor');
    group.add('bpoc');
    group.add('bsoj');
    group.add('bdsu');
    group.add('bdsy');
    group.add('cell');
    group.add('celc');
    group.add('emst');
    group.add('ffas');
    group.add('tisu');
    selectGroup(group);
}

function selectChemicalsAndDrugs() {
    // aapp, antb, bacs, bodm, carb, chem, chvf, chvs, clnd, eico, elii, enzy, hops, horm, imft, irda, inch, lipd, nsba, nnon, orch, opco, phsu, rcpt, strd, vita
    let group = new Set();
    group.add('aapp'),
    group.add('antb'),
    group.add('bacs'),
    group.add('bodm'),
    group.add('carb'),
    group.add('chem'),
    group.add('chvf'),
    group.add('chvs'),
    group.add('clnd'),
    group.add('eico'),
    group.add('elii'),
    group.add('enzy'),
    group.add('hops'),
    group.add('horm'),
    group.add('imft'),
    group.add('irda'),
    group.add('inch'),
    group.add('lipd'),
    group.add('nsba'),
    group.add('nnon'),
    group.add('orch'),
    group.add('opco'),
    group.add('phsu'),
    group.add('rcpt'),
    group.add('strd'),
    group.add('vita')
    selectGroup(group);
}

function selectConceptsAndIdeas() {
    // clas, cnce, ftcn, grpa, idcn, inpr, lang, qlco, rnlw, spco, tmco
    let group = new Set();
    group.add('clas'),
    group.add('cnce'),
    group.add('ftcn'),
    group.add('grpa'),
    group.add('idcn'),
    group.add('inpr'),
    group.add('lang'),
    group.add('qlco'),
    group.add('rnlw'),
    group.add('spco'),
    group.add('tmco')
    selectGroup(group);
}

function selectDevices() {
    // drdd, medd, resd
    let group = new Set();
    group.add('drdd'),
    group.add('medd'),
    group.add('resd')
    selectGroup(group);
}

function selectDisorders() {
    // acab,anab,bact,comd,cgab,dsyn,emod,fndg,inpo,mobd,neop,patf,sosy
    let disorders = new Set();
    disorders.add('acab');
    disorders.add('anab');
    disorders.add('bact');
    disorders.add('comd');
    disorders.add('cgab');
    disorders.add('dsyn');
    disorders.add('emod');
    disorders.add('fndg');
    disorders.add('inpo');
    disorders.add('mobd');
    disorders.add('patf');
    disorders.add('sosy');
    selectGroup(disorders);
}


// abbreviated disorders group, finding and congenital abnormality removed
function selectDisordersAbbrev() {
    // acab,anab,bact,cgab,dsyn,emod,inpo,mobd,neop,patf,sosy
    let disorders = new Set();
    disorders.add('acab');
    disorders.add('anab');
    disorders.add('bact');
    disorders.add('cgab');
    disorders.add('dsyn');
    disorders.add('emod');
    disorders.add('inpo');
    disorders.add('mobd');
    disorders.add('patf');
    disorders.add('sosy');
    selectGroup(disorders);
}


function selectGenesAndMolecularSequences() {
    // amas, crbs, gngm, mosq, nusq
    let group = new Set();
    group.add('amas'),
    group.add('crbs'),
    group.add('gngm'),
    group.add('mosq'),
    group.add('nusq'),
    selectGroup(group);
}

function selectGeographicAreas() {
    // geoa
    let group = new Set();
    group.add('geoa'),
    selectGroup(group);
}

function selectLivingBeings() {
    // aggp, amph, anim, arch, bact, bird, euka, fish, fngs, grup,
    // humn, mamm, orgm, podg, plnt, popg, prog, rept, vtbt, virs
    let group = new Set();
    group.add('aggp')
    group.add('amph')
    group.add('anim')
    group.add('arch')
    group.add('bact')
    group.add('bird')
    group.add('euka')
    group.add('fish')
    group.add('fngs')
    group.add('grup')
    group.add('humn')
    group.add('mamm')
    group.add('orgm')
    group.add('podg')
    group.add('plnt')
    group.add('popg')
    group.add('prog')
    group.add('rept')
    group.add('vtbt')
    group.add('virs')
    selectGroup(group);
}

function selectObjects() {
    // enty, food, mnob, sbst
    let group = new Set();
    group.add('enty');
    group.add('food')
    group.add('mnob')
    group.add('sbst')
    selectGroup(group);
}

function selectOccupations() {
    // bmod, ocdi
    let group = new Set();
    group.add('bmod')
    group.add('ocdi')
    selectGroup(group);
}

function selectOrganizations() {
    // hcro, orgt, pros, shro
    let group = new Set();
    group.add('hcro')
    group.add('orgt')
    group.add('pros')
    group.add('shro')
    selectGroup(group);
}

function selectPhenomena() {
    // eehu, hcpp, lbtr, npop, phpr
    let group = new Set();
    group.add('eehu')
    group.add('hcpp')
    group.add('lbtr')
    group.add('npop')
    group.add('phpr')
    selectGroup(group);
}

function selectPhysiology() {
    // celf, clna, clnd, 
    let group = new Set();
    group.add('celf')
    group.add('clna')
    group.add('clnd')
    selectGroup(group);
}

function selectProcedures() {
    // diap, edac, hlca, lbpr, mbrt, resa, topp
    let group = new Set();
    group.add('diap')
    group.add('edac')
    group.add('hlca')
    group.add('lbpr')
    group.add('mbrt')
    group.add('resa')
    group.add('topp')
    selectGroup(group);
}

function clearSemanticTypes() {
    var elementlist = document.getElementById('iForm').elements;
    // using reference to elementlist obtained above
    for (var i=0, len=elementlist.length; i<len; i++) {
        // dbg: console.info(elementlist[i]);
        var nameval = elementlist[i].getAttribute("name");
        if (nameval == "semanticTypeString") {
	    elementlist[i].removeAttribute("checked");
        }
    }    
}
