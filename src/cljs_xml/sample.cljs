(ns cljs-xml.sample)


(def tei
  "<TEI xmlns=\"http://www.tei-c.org/ns/1.0\">
  <teiHeader>
    <fileDesc>
      <titleStmt>
	<title>À Rabel, peintre, sur un livre de fleurs</title>
	<author>François de Malherbe</author>
      </titleStmt>
      <extent>
      </extent>

      <publicationStmt>
	<publisher>
	</publisher>
      </publicationStmt>
      <sourceDesc>
	<bibl>
	</bibl>
      </sourceDesc>
    </fileDesc>
    
    <encodingDesc>
      <projectDesc>
	<p>Sample text for developing the feuillage TEI editing tool.</p>
      </projectDesc>

    </encodingDesc>
  </teiHeader>
  <text>
    <body>
      <div type=\"poem\">
	<head type=\"title\">À Rabel, peintre, sur un livre de fleurs</head>
	<lg type=\"stanza\" n=\"1\">
	  <l n=\"1\">Quelques louanges nonpareilles</l>
	  <l n=\"2\">Qu'ait Apelle encor aujourd'hui,</l>
	  <l n=\"3\">Cet ouvrage plein de merveilles</l>
	  <l n=\"4\">Met Rabel au-dessus de lui.</l>
	</lg>
	<lg type=\"stanza\" n=\"2\">
	  <l n=\"5\">L'art y surmonte la nature,</l>
	  <l n=\"6\">Et si mon jugement n'est vain,</l>
	  <l n=\"7\">Flore lui conduisait la main</l>
	  <l n=\"8\">Quand il faisait cette peinture.</l>
	</lg>
	<lg type=\"stanza\" n=\"3\">
	  <l n=\"9\">Certes il a privé mes yeux</l>
	  <l n=\"10\">De l'objet qu'ils aiment le mieux,</l>
	  <l n=\"11\">N'y mettant point de marguerite</l>
	</lg>
	<lg type=\"stanza\" n=\"4\">
	  <l n=\"12\">Mais pouvait-il être ignorant</l>
	  <l n=\"13\">Qu'une fleur de tant de mérite</l>
	  <l n=\"14\">Aurait terni le demeurant.</l>
	</lg>
      </div>
    </body>
  </text>
</TEI>")
